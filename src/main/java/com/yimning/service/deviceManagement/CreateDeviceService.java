package com.yimning.service.deviceManagement;

import com.yimning.entity.deviceManagement.AddDevice;
import com.yimning.entity.deviceManagement.AddDeviceResponse;

public interface CreateDeviceService {
    /** 
     * @Description: 创建设备
     */
    public AddDeviceResponse createDevice(AddDevice addDevice) throws Exception ;

}
