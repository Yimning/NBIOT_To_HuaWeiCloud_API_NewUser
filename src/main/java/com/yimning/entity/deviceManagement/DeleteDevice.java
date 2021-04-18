package com.yimning.entity.deviceManagement;

import lombok.Data;

/**
 * @program: yimning
 * @description: 删除设备请求参数
 * @author: Yimning
 * @create: 2021-04-18 20:19
 **/
@Data
public class DeleteDevice {

    private String project_id;
    private String device_id;
}
