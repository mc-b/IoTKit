/*----------------------------------------------------------------------------------------------
 * $RCSFile: $, Created on 24.08.2015
 *
 * (c) 1999 - 2012, Huerlimann Informatik AG, Zufikon, alle Rechte vorbehalten
 *---------------------------------------------------------------------------------------------*/

package ch.iotkit.smarthome.binding.mbedRPC;

import java.util.Set;

import org.eclipse.smarthome.core.thing.ThingTypeUID;

import com.google.common.collect.ImmutableSet;

/*******************************************************************************
 * Konstanten fuer thing-types.xml
 * <p>
 *
 * @version $Revision: $ $Date: $
 * @author mbern
 *******************************************************************************/

public class IoTKitConstants
{
    public static final String BINDING_ID = "iotkit";

    // List all Thing Type UIDs, related to the IoTKit SMD Shield Binding
    public final static ThingTypeUID THING_TYPE_IOTKIT_BRIDGE = new ThingTypeUID( BINDING_ID, "bridge" );
    public final static ThingTypeUID THING_TYPE_IOTKIT_SENSORS = new ThingTypeUID( BINDING_ID, "sensors" );
    public final static ThingTypeUID THING_TYPE_IOTKIT_ACTORS = new ThingTypeUID( BINDING_ID, "actors" );
    public final static ThingTypeUID THING_TYPE_IOTKIT_LEDS = new ThingTypeUID( BINDING_ID, "leds" );
    public final static ThingTypeUID THING_TYPE_IOTKIT_LEDSTRIP = new ThingTypeUID( BINDING_ID, "ledstrip" );

    // List Sensors channels
    public static final String CHANNEL_TEMP = "temp";
    public static final String CHANNEL_POTI = "poti";
    public static final String CHANNEL_LIGHT = "light";
    public static final String CHANNEL_HALL = "hall";

    // List Actors channels
    public static final String CHANNEL_MOTOR = "motor";
    public static final String CHANNEL_SERVO = "servo";
    public static final String CHANNEL_STEPPER = "stepper";

    // Standard LED dimmbar auf Shield
    public static final String CHANNEL_LED = "led";

    // set of all Things
    public final static Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = ImmutableSet.of( THING_TYPE_IOTKIT_SENSORS,
                    THING_TYPE_IOTKIT_ACTORS, THING_TYPE_IOTKIT_BRIDGE, THING_TYPE_IOTKIT_LEDS, THING_TYPE_IOTKIT_LEDSTRIP );


}
