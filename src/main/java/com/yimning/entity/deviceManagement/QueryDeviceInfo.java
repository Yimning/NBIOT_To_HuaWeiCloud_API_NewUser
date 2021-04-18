package com.yimning.entity.deviceManagement;

import lombok.Data;

/**
 * @program: yimning
 * @description: 查询某个设备的请求参数
 * @author: Yimning
 * @create: 2021-04-18 17:17
 **/
@Data
public class QueryDeviceInfo {

    private String project_id;
    private String device_id;
}
