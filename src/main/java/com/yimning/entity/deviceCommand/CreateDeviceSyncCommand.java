package com.yimning.entity.deviceCommand;

import lombok.Data;

/**
 * @program: yimning
 * @description: 设备同步命令参数
 * @author: Yimning
 * @create: 2021-04-20 14:53
 **/
@Data
public class CreateDeviceSyncCommand {
    private String  project_id;
    private  String device_id;
    private String service_id;
    private String command_name;
    private Paras paras;
}
