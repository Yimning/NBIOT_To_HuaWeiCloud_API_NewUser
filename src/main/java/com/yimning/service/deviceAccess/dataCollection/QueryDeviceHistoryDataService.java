package com.yimning.service.deviceAccess.dataCollection;

import com.yimning.entity.DeviceHistoryData;

public interface QueryDeviceHistoryDataService {
    /** 
     * @Description: 查设备服务能力
     */
    public DeviceHistoryData QueryDeviceHistoryData(DeviceHistoryData deviceHistoryData) throws Exception ;

}
