package com.yimning.service.deviceManagement;

import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.deviceManagement.FreezeDevice;

public interface FreezeDeviceService {
    /**
     * @Description: 冻结设备
     */
    public HttpResponseResult freezeDevice(FreezeDevice freezeDevice) throws Exception;
}