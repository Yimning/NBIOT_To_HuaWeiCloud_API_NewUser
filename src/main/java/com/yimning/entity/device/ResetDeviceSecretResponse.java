package com.yimning.entity.device;

import com.yimning.common.lang.HttpResponseResult;
import lombok.Data;

/**
 * @program: yimning
 * @description: 重置设备密钥响应结果
 * @author: Yimning
 * @create: 2021-04-18 20:48
 **/
@Data
public class ResetDeviceSecretResponse {
    private String device_id;
    private String secret;
    private HttpResponseResult httpResponseResult;
}
