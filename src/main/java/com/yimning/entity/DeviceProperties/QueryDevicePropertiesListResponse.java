package com.yimning.entity.DeviceProperties;

import com.yimning.common.lang.HttpResponseResult;
import lombok.Data;

/**
 * @program: yimning
 * @description: 查询设备属性的响应结果
 * @author: Yimning
 * @create: 2021-04-20 16:34
 **/
@Data
public class QueryDevicePropertiesListResponse {
    private Response response;
    private HttpResponseResult httpResponseResult;
}
