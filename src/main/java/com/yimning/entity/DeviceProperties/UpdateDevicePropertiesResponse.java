package com.yimning.entity.DeviceProperties;

import com.yimning.common.lang.HttpResponseResult;
import lombok.Data;

/**
 * @program: yimning
 * @description: 修改设备属性响应结果
 * @author: Yimning
 * @create: 2021-04-20 17:25
 **/
@Data
public class UpdateDevicePropertiesResponse {
    private Responses response;
    private HttpResponseResult httpResponseResult;
}
