package com.yimning.entity.deviceMessage;

import lombok.Data;

/**
 * @program: yimning
 * @description:
 * @author: Yimning
 * @create: 2021-04-19 14:53
 **/
@Data
public class MessageResult {
    private String status;
    private String created_time;
    private String finished_time;
}
