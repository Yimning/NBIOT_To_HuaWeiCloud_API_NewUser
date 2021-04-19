package com.yimning.entity.deviceMessage;

import com.yimning.common.lang.HttpResponseResult;
import lombok.Data;

import java.util.List;

/**
 * @program: yimning
 * @description: 查询设备消息列表响应结果
 * @author: Yimning
 * @create: 2021-04-18 23:11
 **/
@Data
public class QueryDeviceMessageListResponse {
    private String device_id;
    private List<DeviceMessage> messages;
    private HttpResponseResult httpResponseResult;
}
