package com.yimning.entity.DeviceProperties;

import lombok.Data;

import java.util.List;

/**
 * @program: yimning
 * @description: 修改设备属性参数
 * @author: Yimning
 * @create: 2021-04-20 17:25
 **/
@Data
public class UpdateDeviceProperties {
    private String device_id;
    private String project_id;
    private List<Services> services;
}
