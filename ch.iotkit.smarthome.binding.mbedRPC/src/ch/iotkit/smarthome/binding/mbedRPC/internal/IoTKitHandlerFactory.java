/*----------------------------------------------------------------------------------------------
 * $RCSFile: $, Created on 24.08.2015
 *
 * (c) 1999 - 2012, Huerlimann Informatik AG, Zufikon, alle Rechte vorbehalten
 *---------------------------------------------------------------------------------------------*/

package ch.iotkit.smarthome.binding.mbedRPC.internal;

import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;

import ch.iotkit.smarthome.binding.mbedRPC.IoTKitConstants;
import ch.iotkit.smarthome.binding.mbedRPC.handler.IoTKitActorsHandler;
import ch.iotkit.smarthome.binding.mbedRPC.handler.IoTKitBridgeHandler;
import ch.iotkit.smarthome.binding.mbedRPC.handler.IoTKitSensorsHandler;

/*******************************************************************************
 * Erstellt die Handler fuer Bridge und Things.
 * <p>
 *
 * @version $Revision: $ $Date: $
 * @author mbern
 *******************************************************************************/

public class IoTKitHandlerFactory extends BaseThingHandlerFactory
{

    /* (non-Javadoc)
     * @see org.eclipse.smarthome.core.thing.binding.ThingHandlerFactory#supportsThingType(org.eclipse.smarthome.core.thing.ThingTypeUID)
     */
    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID)
    {
        return IoTKitConstants.SUPPORTED_THING_TYPES_UIDS.contains( thingTypeUID );
    }

    /* (non-Javadoc)
     * @see org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory#createHandler(org.eclipse.smarthome.core.thing.Thing)
     */
    @Override
    protected ThingHandler createHandler( Thing thing )
    {
        ThingTypeUID thingTypeUID = thing.getThingTypeUID();

        // Bridge
        if ( thingTypeUID.equals( IoTKitConstants.THING_TYPE_IOTKIT_BRIDGE ) )
            return new IoTKitBridgeHandler( (Bridge) thing );

        // Things
        if ( thingTypeUID.equals( IoTKitConstants.THING_TYPE_IOTKIT_SENSORS ) )
            return new IoTKitSensorsHandler( thing );
        if ( thingTypeUID.equals( IoTKitConstants.THING_TYPE_IOTKIT_ACTORS ) )
            return new IoTKitActorsHandler( thing );
        return null;
    }

}
