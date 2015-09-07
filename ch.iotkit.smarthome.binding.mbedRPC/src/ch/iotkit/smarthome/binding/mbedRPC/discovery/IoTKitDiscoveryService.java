/*----------------------------------------------------------------------------------------------
    Copyright (c) 2015 Marcel (mc-b) Bernet, Zurich (haftungsbeschraenkt) and others.
    All rights reserved. This program and the accompanying materials
    are made available under the terms of the Eclipse Public License v1.0
    which accompanies this distribution, and is available at
    http://www.eclipse.org/legal/epl-v10.html
 *---------------------------------------------------------------------------------------------*/

package ch.iotkit.smarthome.binding.mbedRPC.discovery;

import java.util.Set;

import org.eclipse.smarthome.config.discovery.AbstractDiscoveryService;
import org.eclipse.smarthome.core.thing.ThingTypeUID;

import ch.iotkit.smarthome.binding.mbedRPC.IoTKitConstants;

/*******************************************************************************
 * DiscoveryService
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
