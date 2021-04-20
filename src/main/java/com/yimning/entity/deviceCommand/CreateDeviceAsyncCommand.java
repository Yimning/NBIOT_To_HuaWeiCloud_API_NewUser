package com.yimning.entity.deviceCommand;

import lombok.Data;

/**
 * @program: yimning
 * @description: 设备异步命令
 * @author: Yimning
 * @create: 2021-04-20 14:56
 **/
@Data
public class CreateDeviceAsyncCommand {
    private String  project_id;
    private  String device_id;
    private String service_id;
    private String command_name;
    private Paras paras;
    private int expire_time;
    private String send_strategy;
}
