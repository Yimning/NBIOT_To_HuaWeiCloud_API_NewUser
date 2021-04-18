package com.yimning.service.deviceManagement;

import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.device.DeleteDevice;
import com.yimning.entity.device.ResetDeviceSecret;
import com.yimning.entity.device.ResetDeviceSecretResponse;

public interface ResetDeviceSecretService {
    /**
     * @Description: 重置设备密钥
     */
    public ResetDeviceSecretResponse resetDeviceSecret(ResetDeviceSecret resetDeviceSecret) throws Exception;
}