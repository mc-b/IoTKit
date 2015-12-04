/*----------------------------------------------------------------------------------------------
    Copyright (c) 2015 Marcel (mc-b) Bernet, Zurich (haftungsbeschraenkt) and others.
    All rights reserved. This program and the accompanying materials
    are made available under the terms of the Eclipse Public License v1.0
    which accompanies this distribution, and is available at
    http://www.eclipse.org/legal/epl-v10.html
 *---------------------------------------------------------------------------------------------*/

package org.openhab.binding.iotkit.handler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.eclipse.smarthome.config.core.Configuration;
import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.binding.BaseBridgeHandler;
import org.eclipse.smarthome.core.types.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*******************************************************************************
 * Bridge IoTKit SMD Shield. Stellt Verbindung via MBED RPC zum Shield her.
 * <p>
 *******************************************************************************/

public class IoTKitBridgeHandler extends BaseBridgeHandler
{
    private Logger logger = LoggerFactory.getLogger( IoTKitBridgeHandler.class );
    /** IP-Adresse SMD Shield */
    private String addr;

    /*
     * (non-Javadoc)
     * @see org.eclipse.smarthome.core.thing.binding.BaseThingHandler#initialize()
     */
    @Override
    public void initialize()
    {
        logger.debug( "Initializing IoTKit Bridge handler." );
        super.initialize();

        Configuration config = getThing().getConfiguration();
        if ( config != null ) addr = (String) config.get( "address" );
    }

    /**
     * @param bridge
     */
    public IoTKitBridgeHandler(Bridge bridge)
    {
        super( bridge );
    }

    /*
     * (non-Javadoc)
     * @see
     * org.eclipse.smarthome.core.thing.binding.ThingHandler#handleCommand(org.eclipse.smarthome.core.thing.ChannelUID,
     * org.eclipse.smarthome.core.types.Command)
     */
    @Override
    public void handleCommand(ChannelUID channelUID, Command command)
    {
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // I/O Methoden
    //
    /////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Lesen eines Werte vom IoTKit Shield
     *
     * @param thing Id des Things auf dem Shield
     * @return Wert
     */
    public String read(String thing)
    {
        String urlString = "http://" + addr + "/rpc/" + thing + "/read";
        String value = null;

        try
        {
            URL url = new URL( urlString );
            URLConnection connection = url.openConnection();
            value = IOUtils.toString( connection.getInputStream() );
        }
        catch (MalformedURLException e)
        {
            logger.debug( "Constructed url '{}' is not valid: {}", urlString, e.getMessage() );
        }
        catch (IOException e)
        {
            logger.error( "Error accessing url '{}' : {} ", urlString, e.getMessage() );
        }

        return value;
    }

    /**
     * Schreiben eines Wertes
     *
     * @param thing Thin auf dem Shield
     * @param value Wert
     */
    public void write(String thing, String value)
    {
        String urlString = "http://" + addr + "/rpc/" + thing + "/write+" + value;
        try
        {
            URL url = new URL( urlString );
            URLConnection connection = url.openConnection();
            // braucht explizit das lesen des RC Wertes, connect alleine genuegt nicht!
            value = IOUtils.toString( connection.getInputStream() );
        }
        catch (MalformedURLException e)
        {
            logger.debug( "Constructed url '{}' is not valid: {}", urlString, e.getMessage() );
        }
        catch (IOException e)
        {
            logger.error( "Error accessing url '{}' : {} ", urlString, e.getMessage() );
        }
    }

    /**
     * Aufruf einer Funktion z.B. up, down, stop
     *
     * @param thing Thing auf dem Shield
     * @param func Funktion
     */
    public void func(String thing, String func)
    {
        String urlString = "http://" + addr + "/rpc/" + thing + "/" + func;
        try
        {
            URL url = new URL( urlString );
            URLConnection connection = url.openConnection();
            // braucht explizit das lesen des RC Wertes, connect alleine genuegt nicht!
            IOUtils.toString( connection.getInputStream() );
        }
        catch (MalformedURLException e)
        {
            logger.debug( "Constructed url '{}' is not valid: {}", urlString, e.getMessage() );
        }
        catch (IOException e)
        {
            logger.error( "Error accessing url '{}' : {} ", urlString, e.getMessage() );
        }
    }

}
