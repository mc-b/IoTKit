/*----------------------------------------------------------------------------------------------
    Copyright (c) 2015 Marcel (mc-b) Bernet, Zurich (haftungsbeschraenkt) and others.
    All rights reserved. This program and the accompanying materials
    are made available under the terms of the Eclipse Public License v1.0
    which accompanies this distribution, and is available at
    http://www.eclipse.org/legal/epl-v10.html
 *---------------------------------------------------------------------------------------------*/

package ch.iotkit.smarthome.binding.mbedRPC.handler;

import org.eclipse.smarthome.core.library.types.HSBType;
import org.eclipse.smarthome.core.library.types.OnOffType;
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
 *******************************************************************************/

public class IoTKitLEDStripHandler extends BaseThingHandler
{
    private Logger logger = LoggerFactory.getLogger( IoTKitLEDStripHandler.class );

    /**
     * Default Konstruktor - wird von {@link IoTKitHandlerFactory} aufrufen
     * 
     * @param thing
     */
    public IoTKitLEDStripHandler(Thing thing)
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
        logger.debug( "Initializing IoTKit LED Strip handler." );
        super.initialize();
    }

    /**
     * Commands vom UI abhandeln
     */
    @Override
    public void handleCommand(ChannelUID channelUID, Command command)
    {
        // Prozentaler Wert, z.B. bei Servos
        if ( command instanceof HSBType )
        {
            System.out.println( "RGB" + ( (HSBType) command ).getRGB() + " " + ( (HSBType) command ).getRed().doubleValue() + ","
                            + ( (HSBType) command ).getGreen().doubleValue() + ","
                            + ( (HSBType) command ).getBlue().doubleValue() );
            getIoTKitBridge().write( channelUID.getId(), String.valueOf( ( (HSBType) command ).getRGB() ) );
        } else if ( command instanceof OnOffType )
        {
            switch (( (OnOffType) command ))
            {
                case ON:
                    getIoTKitBridge().write( channelUID.getId(), "16777215" ); // 0xFFFFFF
                    break;
                case OFF:
                    getIoTKitBridge().write( channelUID.getId(), "0" );
                    break;
            }
        } else
            logger.debug( "Command {} is not supported for channel: {}", command, channelUID.getId() );
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Getter
    //
    /////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Zugriff Bridge - Verbindung zum IoTKit SMD Shield
     * 
     * @return
     */
    protected IoTKitBridgeHandler getIoTKitBridge()
    {
        return (IoTKitBridgeHandler) getBridge().getHandler();
    }
}
