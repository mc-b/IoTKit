/*----------------------------------------------------------------------------------------------
    Copyright (c) 2015 Marcel (mc-b) Bernet, Zurich (haftungsbeschraenkt) and others.
    All rights reserved. This program and the accompanying materials
    are made available under the terms of the Eclipse Public License v1.0
    which accompanies this distribution, and is available at
    http://www.eclipse.org/legal/epl-v10.html
 *---------------------------------------------------------------------------------------------*/

package org.openhab.binding.iotkit.handler;

import org.eclipse.smarthome.core.library.types.OnOffType;
import org.eclipse.smarthome.core.library.types.PercentType;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.types.Command;
import org.openhab.binding.iotkit.internal.IoTKitHandlerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*******************************************************************************
 * IoTKit SMS Shield LED's Handler.
 * <p>
 *******************************************************************************/

public class IoTKitLEDsHandler extends BaseThingHandler
{
    private Logger logger = LoggerFactory.getLogger( IoTKitLEDsHandler.class );

    /**
     * Default Konstruktor - wird von {@link IoTKitHandlerFactory} aufrufen
     * 
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
        if ( command instanceof PercentType )
        {
            getIoTKitBridge().write( channelUID.getId(), String.valueOf( ( (PercentType) command ).doubleValue() / 100.0 ) );
        } else if ( command instanceof OnOffType )
        {
            switch (( (OnOffType) command ))
            {
                case ON:
                    getIoTKitBridge().write( channelUID.getId(), "1.0" );
                    break;
                case OFF:
                    getIoTKitBridge().write( channelUID.getId(), "0.0" );
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
