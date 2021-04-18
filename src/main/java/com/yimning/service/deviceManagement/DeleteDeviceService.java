package com.yimning.service.deviceManagement;

import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.device.DeleteDevice;

public interface DeleteDeviceService {
    /**
     * @Description: 删除设备
     */
    public HttpResponseResult deleteDevice(DeleteDevice deleteDevice) throws Exception;
}