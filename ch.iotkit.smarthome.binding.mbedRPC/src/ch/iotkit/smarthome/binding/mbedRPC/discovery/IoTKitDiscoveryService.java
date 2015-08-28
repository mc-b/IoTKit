/*----------------------------------------------------------------------------------------------
 * $RCSFile: $, Created on 24.08.2015
 *
 * (c) 1999 - 2012, Huerlimann Informatik AG, Zufikon, alle Rechte vorbehalten
 *---------------------------------------------------------------------------------------------*/

package ch.iotkit.smarthome.binding.mbedRPC.discovery;

import java.util.Set;

import org.eclipse.smarthome.config.discovery.AbstractDiscoveryService;
import org.eclipse.smarthome.core.thing.ThingTypeUID;

import ch.iotkit.smarthome.binding.mbedRPC.IoTKitConstants;

/*******************************************************************************
 * TODO
 * <p>
 *
 * @version $Revision: $ $Date: $
 * @author mbern
 *******************************************************************************/

public class IoTKitDiscoveryService extends AbstractDiscoveryService
{

    public IoTKitDiscoveryService()
    {
        super( IoTKitConstants.SUPPORTED_THING_TYPES_UIDS, 10 );
    }

    @Override
    public Set<ThingTypeUID> getSupportedThingTypes()
    {
        return ( IoTKitConstants.SUPPORTED_THING_TYPES_UIDS );
    }

    private void discoverLocation()
    {

    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.smarthome.config.discovery.AbstractDiscoveryService#startScan()
     */
    @Override
    protected void startScan()
    {
        discoverLocation();
        removeOlderResults( getTimestampOfLastScan() );
    }

}
