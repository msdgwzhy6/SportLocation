package com.yxc.location.map.location.event;

import com.amap.api.location.AMapLocation;
import com.yxc.location.map.model.RecordLocation;

/**
 * @author yxc
 * @date 2019-06-14
 */
public class LocationEvent {

   public final AMapLocation mapLocation;

   public final RecordLocation recordLocation;

   public LocationEvent(AMapLocation mapLocation, RecordLocation recordLocation){
        this.mapLocation = mapLocation;
        this.recordLocation = recordLocation;
   }
}
