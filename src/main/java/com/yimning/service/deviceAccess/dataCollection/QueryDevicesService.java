package com.yimning.service.deviceAccess.dataCollection;

import com.yimning.entity.DeviceDataInfos;

public interface QueryDevicesService {
    /**
     *  
     *
     * @Description: 查所有设备数据
     */
    public DeviceDataInfos QueryDevices(DeviceDataInfos deviceDataInfos) throws Exception;

}

