/*----------------------------------------------------------------------------------------------
 * $RCSFile: $, Created on 24.08.2015
 *
 * (c) 1999 - 2012, Huerlimann Informatik AG, Zufikon, alle Rechte vorbehalten
 *---------------------------------------------------------------------------------------------*/

package ch.iotkit.smarthome.binding.mbedRPC.handler;

import org.eclipse.smarthome.core.library.types.PercentType;
import org.eclipse.smarthome.core.library.types.StopMoveType;
import org.eclipse.smarthome.core.library.types.UpDownType;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.types.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.iotkit.smarthome.binding.mbedRPC.internal.IoTKitHandlerFactory;

/*******************************************************************************
 * IoTKit SMS Shield Actors Handler.
 * <p>
 *
 * @version $Revision: $ $Date: $
 * @author mbern
 *******************************************************************************/

public class IoTKitActorsHandler extends BaseThingHandler
{
    private Logger logger = LoggerFactory.getLogger( IoTKitActorsHandler.class );

    /**
     * Default Konstruktor - wird von {@link IoTKitHandlerFactory} aufrufen
     * @param thing
     */
    public IoTKitActorsHandler(Thing thing)
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
        logger.debug( "Initializing IoTKit Actors handler." );
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
        // Up / Down Button
        else if  ( command instanceof UpDownType )
        {
            getIoTKitBridge().func( channelUID.getId(), command.toString().toLowerCase() );
        }
        // Stop Button (bei Up/Down)
        else if ( command instanceof StopMoveType )
        {
            getIoTKitBridge().func( channelUID.getId(), command.toString().toLowerCase() );
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
