/*----------------------------------------------------------------------------------------------
    Copyright (c) 2015 Marcel (mc-b) Bernet, Zurich (haftungsbeschraenkt) and others.
    All rights reserved. This program and the accompanying materials
    are made available under the terms of the Eclipse Public License v1.0
    which accompanies this distribution, and is available at
    http://www.eclipse.org/legal/epl-v10.html
 *---------------------------------------------------------------------------------------------*/

package org.openhab.binding.iotkit.internal;

import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
import org.openhab.binding.iotkit.IoTKitConstants;
import org.openhab.binding.iotkit.handler.IoTKitActorsHandler;
import org.openhab.binding.iotkit.handler.IoTKitBridgeHandler;
import org.openhab.binding.iotkit.handler.IoTKitLEDStripHandler;
import org.openhab.binding.iotkit.handler.IoTKitLEDsHandler;
import org.openhab.binding.iotkit.handler.IoTKitSensorsHandler;

/*******************************************************************************
 * Erstellt die Handler fuer Bridge und Things.
 * <p>
 *******************************************************************************/

public class IoTKitHandlerFactory extends BaseThingHandlerFactory
{

    /*
     * (non-Javadoc)
     * @see
     * org.eclipse.smarthome.core.thing.binding.ThingHandlerFactory#supportsThingType(org.eclipse.smarthome.core.thing.
     * ThingTypeUID)
     */
    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID)
    {
        return IoTKitConstants.SUPPORTED_THING_TYPES_UIDS.contains( thingTypeUID );
    }

    /*
     * (non-Javadoc)
     * @see
     * org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory#createHandler(org.eclipse.smarthome.core.thing.
     * Thing)
     */
    @Override
    protected ThingHandler createHandler(Thing thing)
    {
        ThingTypeUID thingTypeUID = thing.getThingTypeUID();

        // Bridge
        if ( thingTypeUID.equals( IoTKitConstants.THING_TYPE_IOTKIT_BRIDGE ) ) return new IoTKitBridgeHandler( (Bridge) thing );

        // Things
        if ( thingTypeUID.equals( IoTKitConstants.THING_TYPE_IOTKIT_SENSORS ) ) return new IoTKitSensorsHandler( thing );
        if ( thingTypeUID.equals( IoTKitConstants.THING_TYPE_IOTKIT_ACTORS ) ) return new IoTKitActorsHandler( thing );
        if ( thingTypeUID.equals( IoTKitConstants.THING_TYPE_IOTKIT_LEDS ) ) return new IoTKitLEDsHandler( thing );
        if ( thingTypeUID.equals( IoTKitConstants.THING_TYPE_IOTKIT_LEDSTRIP ) ) return new IoTKitLEDStripHandler( thing );
        return null;
    }

}
