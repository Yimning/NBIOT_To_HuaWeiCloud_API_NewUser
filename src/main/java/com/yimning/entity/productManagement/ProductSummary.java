package com.yimning.entity.productManagement;

import lombok.Data;

/**
 * @program: yimning
 * @description: 产品信息列表
 * @author: Yimning
 * @create: 2021-04-17 15:50
 **/
@Data
public class ProductSummary {
    private String app_id;
    private String app_name;
    private String product_id;
    private String name;
    private String device_type;
    private String protocol_type;
    private String data_format;
    private String manufacturer_name;
    private String industry;
    private String description;
    private String create_time;
}
