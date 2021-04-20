package com.yimning.entity.deviceCommand;

import com.yimning.common.lang.HttpResponseResult;
import lombok.Data;
import sun.security.jgss.HttpCaller;

/**
 * @program: yimning
 * @description: 查询指定id的设备异步命令响应结果
 * @author: Yimning
 * @create: 2021-04-20 16:10
 **/
@Data
public class QueryDeviceAsyncCommandByCommandIDResponse {
    private String device_id;
    private String command_id;
    private String service_id;
    private String command_name;
    private Paras paras;
    private int expire_time;
    private String send_strategy;
    private String created_time;
    private String status;
    private Result result;
    private String sent_time;
    private String delivered_time;
    private String response_time;
    private HttpResponseResult httpResponseResult;
}
