package com.yimning.entity.deviceMessage;

import lombok.Data;

/**
 * @program: yimning
 * @description: 查询某个设备消息
 * @author: Yimning
 * @create: 2021-04-18 23:11
 **/
@Data
public class QueryDeviceMessageByID {
    private String project_id;
    private String device_id;
    private String message_id;//下发消息的消息ID,用于唯一标识一个消息,在消息下发时由物联网平台分配获得
}
