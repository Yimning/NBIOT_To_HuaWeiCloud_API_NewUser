package com.yimning.entity.DeviceProperties;

import lombok.Data;

/**
 * @program: yimning
 * @description: 查询设备属性的请求参数
 * @author: Yimning
 * @create: 2021-04-20 16:34
 **/
@Data
public class QueryDevicePropertiesList {
    private String device_id;
    private String project_id;
    private String service_id;

}
