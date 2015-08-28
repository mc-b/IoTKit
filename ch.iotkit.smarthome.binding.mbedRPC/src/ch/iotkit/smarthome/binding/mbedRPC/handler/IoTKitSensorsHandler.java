/*----------------------------------------------------------------------------------------------
 * $RCSFile: $, Created on 24.08.2015
 *
 * (c) 1999 - 2012, Huerlimann Informatik AG, Zufikon, alle Rechte vorbehalten
 *---------------------------------------------------------------------------------------------*/

package ch.iotkit.smarthome.binding.mbedRPC.handler;

import java.math.BigDecimal;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.smarthome.config.core.Configuration;
import org.eclipse.smarthome.core.library.types.DecimalType;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.types.Command;
import org.eclipse.smarthome.core.types.RefreshType;
import org.eclipse.smarthome.core.types.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.iotkit.smarthome.binding.mbedRPC.IoTKitConstants;
import ch.iotkit.smarthome.binding.mbedRPC.internal.IoTKitHandlerFactory;

/*******************************************************************************
 * Handler fuer Sensoren
 * <p>
 *
 * @version $Revision: $ $Date: $
 * @author mbern
 *******************************************************************************/

public class IoTKitSensorsHandler extends BaseThingHandler
{
    private Logger logger = LoggerFactory.getLogger( IoTKitSensorsHandler.class );
    /** Refresh Intervall */
    private BigDecimal refresh = new BigDecimal( 60 );
    /** Refresh Job */
    ScheduledFuture<?> refreshJob;

    /**
     * Default Konstruktor - wird von {@link IoTKitHandlerFactory} aufrufen
     * @param thing
     */
    public IoTKitSensorsHandler(Thing thing)
    {
        super( thing );
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.smarthome.core.thing.binding.BaseThingHandler#initialize()
     */
    @Override
    public void initialize()
    {
        logger.debug( "Initializing IoTKit Sensors handler." );
        super.initialize();

        Configuration config = getThing().getConfiguration();
        try
        {
            refresh = (BigDecimal) config.get( "refresh" );
        }
        catch (Exception e)
        {
            // let's ignore it and go for the default
        }
        startAutomaticRefresh();
    }

    /**
     * Werte refreshen
     */
    private void startAutomaticRefresh()
    {
        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    updateState( new ChannelUID( getThing().getUID(), IoTKitConstants.CHANNEL_TEMP ), getTemperature() );
                    updateState( new ChannelUID( getThing().getUID(), IoTKitConstants.CHANNEL_POTI ), getPoti() );
                    updateState( new ChannelUID( getThing().getUID(), IoTKitConstants.CHANNEL_LIGHT ), getLight() );
                    updateState( new ChannelUID( getThing().getUID(), IoTKitConstants.CHANNEL_HALL ), getHall() );
                }
                catch (Exception e)
                {
                    logger.debug( "Exception occurred during execution: {}", e.getMessage(), e );
                }
            }
        };
        refreshJob = scheduler.scheduleAtFixedRate( runnable, 0, refresh.intValue(), TimeUnit.SECONDS );
    }

    /**
     * Commands vom UI abhandeln
     */
    @Override
    public void handleCommand(ChannelUID channelUID, Command command)
    {
        if ( command instanceof RefreshType )
        {
            switch (channelUID.getId())
            {
                case IoTKitConstants.CHANNEL_TEMP:
                    updateState( channelUID, getTemperature() );
                    break;
                case IoTKitConstants.CHANNEL_POTI:
                    updateState( channelUID, getPoti() );
                    break;
                case IoTKitConstants.CHANNEL_LIGHT:
                    updateState( channelUID, getLight() );
                    break;
                case IoTKitConstants.CHANNEL_HALL:
                    updateState( channelUID, getHall() );
                    break;
                default:
                    logger.debug( "Command received for an unknown channel: {}", channelUID.getId() );
                    break;
            }
        }
        else
        {
            logger.debug( "Command {} is not supported for channel: {}", command, channelUID.getId() );
        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //  Getter
    //
    /////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Zugriff Bridge - Verbindung zum IoTKit SMD Shield
     * @return
     */
    protected IoTKitBridgeHandler getIoTKitBridge()
    {
        return (IoTKitBridgeHandler) getBridge().getHandler();
    }
    private State getPoti()
    {
        return ( new DecimalType( getIoTKitBridge().read( "poti" ) ) );
    }
    private State getHall()
    {
        return ( new DecimalType( getIoTKitBridge().read( "hall" ) ) );
    }
    private State getLight()
    {
        return ( new DecimalType( getIoTKitBridge().read( "light" ) ) );
    }
    private State getTemperature()
    {
        return ( new DecimalType( getIoTKitBridge().read( "temp" ) ) );
    }
}
