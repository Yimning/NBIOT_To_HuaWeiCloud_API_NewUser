package com.yimning.service.deviceAccess.dataCollection;

import com.yimning.entity.DeviceDataInfo;

public interface QueryDeviceService {
    /** 
     * @Description: 查设备数据
     */
    public DeviceDataInfo QueryDevice(String deviceId) throws Exception ;

}
