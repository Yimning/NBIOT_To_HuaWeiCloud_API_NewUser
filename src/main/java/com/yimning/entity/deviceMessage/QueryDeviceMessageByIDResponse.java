package com.yimning.entity.deviceMessage;

import com.yimning.common.lang.HttpResponseResult;
import lombok.Data;

import java.util.List;

/**
 * @program: yimning
 * @description: 查询某个设备消息响应结果
 * @author: Yimning
 * @create: 2021-04-18 23:11
 **/
@Data
public class QueryDeviceMessageByIDResponse {
    private String message_id;
    private String name;
    private String message;
    private String topic;
    private String status;
    private String created_time;
    private String finished_time;
    private HttpResponseResult httpResponseResult;
}
