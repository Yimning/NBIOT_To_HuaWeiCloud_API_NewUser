package com.yimning.entity.deviceManagement;

import lombok.Data;

import java.util.List;

/**
 * @program: yimning
 * @description:
 * @author: Yimning
 * @create: 2021-04-18 14:57
 **/
@Data
public class QueryDeviceSimplify {
    private String app_id;
    private String app_name;
    private String device_id;
    private String node_id;
    private String gateway_id;
    private String device_name;
    private String node_type;
    private String description;
    private String fw_version;
    private String sw_version;
    private String product_id;
    private String product_name;
    private String status;
    private List<TagV5DTO> tags;
}
