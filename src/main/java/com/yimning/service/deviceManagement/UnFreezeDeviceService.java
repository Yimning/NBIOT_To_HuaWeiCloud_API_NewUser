package com.yimning.service.deviceManagement;

import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.deviceManagement.UnFreezeDevice;

public interface UnFreezeDeviceService {
    /**
     * @Description: 解冻设备
     */
    public HttpResponseResult unFreezeDevice(UnFreezeDevice unFreezeDevice) throws Exception;
}