package com.yimning.entity.deviceCommand;

import com.yimning.common.lang.HttpResponseResult;
import lombok.Data;

/**
 * @program: yimning
 * @description: 设备异步命令响应结果
 * @author: Yimning
 * @create: 2021-04-20 14:56
 **/
@Data
public class CreateDeviceAsyncCommandResponse {
    private String device_id;
    private String command_id;
    private String service_id;
    private String command_name;
    private String send_strategy;
    private Paras paras;
    private int expire_time;
    private String status;
    private String created_time;
    private HttpResponseResult httpResponseResult;
}
