package com.yimning.entity.deviceMessage;

import lombok.Data;

/**
 * @program: yimning
 * @description:
 * @author: Yimning
 * @create: 2021-04-18 23:13
 **/
@Data
public class DeviceMessage {
    private String message_id;
    private String name;
    private String message;
    private String topic;
    private String status;
    private String created_time;
    private String finished_time;
}
