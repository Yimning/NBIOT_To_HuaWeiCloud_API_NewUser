package com.yimning.entity.deviceCommand;

import lombok.Data;

/**
 * @program: yimning
 * @description: 查询指定id的设备异步命令请求参数
 * @author: Yimning
 * @create: 2021-04-20 16:09
 **/
@Data
public class QueryDeviceAsyncCommandByCommandID {
    private String  project_id;
    private  String device_id;
    private String command_id;
}
