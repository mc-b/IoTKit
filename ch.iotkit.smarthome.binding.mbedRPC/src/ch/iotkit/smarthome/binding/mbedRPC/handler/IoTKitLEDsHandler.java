/*----------------------------------------------------------------------------------------------
 * $RCSFile: $, Created on 24.08.2015
 *
 * (c) 1999 - 2012, Huerlimann Informatik AG, Zufikon, alle Rechte vorbehalten
 *---------------------------------------------------------------------------------------------*/

package ch.iotkit.smarthome.binding.mbedRPC.handler;

import org.eclipse.smarthome.core.library.types.OnOffType;
import org.eclipse.smarthome.core.library.types.PercentType;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.types.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.iotkit.smarthome.binding.mbedRPC.internal.IoTKitHandlerFactory;

/*******************************************************************************
 * IoTKit SMS Shield LED's Handler.
 * <p>
 *
 * @version $Revision: $ $Date: $
 * @author mbern
 *******************************************************************************/

public class IoTKitLEDsHandler extends BaseThingHandler
{
    private Logger logger = LoggerFactory.getLogger( IoTKitLEDsHandler.class );

    /**
     * Default Konstruktor - wird von {@link IoTKitHandlerFactory} aufrufen
     * @param thing
     */
    public IoTKitLEDsHandler(Thing thing)
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
        logger.debug( "Initializing IoTKit LED handler." );
        super.initialize();
    }

    /**
     * Commands vom UI abhandeln
     */
    @Override
    public void handleCommand(ChannelUID channelUID, Command command)
    {
        // Prozentaler Wert, z.B. bei Servos
        if  ( command instanceof PercentType )
        {
            getIoTKitBridge().write( channelUID.getId(), String.valueOf( ((PercentType) command).doubleValue() / 100.0 ) );
        }
        else if ( command instanceof OnOffType )
        {
            switch  ( ((OnOffType) command) )
            {
                case    ON:
                    getIoTKitBridge().write( channelUID.getId(), "1.0" );
                    break;
                case    OFF:
                    getIoTKitBridge().write( channelUID.getId(), "0.0" );
                    break;
            }
        }
        else
            logger.debug( "Command {} is not supported for channel: {}", command, channelUID.getId() );
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
}
