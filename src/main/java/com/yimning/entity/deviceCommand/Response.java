package com.yimning.entity.deviceCommand;

import lombok.Data;

/**
 * @program: yimning
 * @description:
 * @author: Yimning
 * @create: 2021-04-20 15:06
 **/
@Data
public class Response {
    private int result_code;
    private String response_name;
    private Paras paras;
}
