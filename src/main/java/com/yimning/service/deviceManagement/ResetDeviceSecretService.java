package com.yimning.service.deviceManagement;

import com.yimning.entity.deviceManagement.ResetDeviceSecret;
import com.yimning.entity.deviceManagement.ResetDeviceSecretResponse;

public interface ResetDeviceSecretService {
    /**
     * @Description: 重置设备密钥
     */
    public ResetDeviceSecretResponse resetDeviceSecret(ResetDeviceSecret resetDeviceSecret) throws Exception;
}