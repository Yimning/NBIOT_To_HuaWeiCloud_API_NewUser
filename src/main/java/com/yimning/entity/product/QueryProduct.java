package com.yimning.entity.product;

import com.yimning.common.lang.HttpResponseResult;
import lombok.Data;

import java.util.List;

/**
 * @program: yimning
 * @description: 查询产品
 * @author: Yimning
 * @create: 2021-04-17 15:45
 **/

@Data
public class QueryProduct {

    private String project_id;//项目ID。获取方法请参见 获取项目ID。

    private    String  product_id;//参数说明：产品ID，用于唯一标识一个产品，在物联网平台创建产品后由平台分配获得。
    //取值范围：长度不超过36，只允许字母、数字、下划线（_）、连接符（-）的组合。

    private String app_id;
    private String app_name;
    private String name;
    private String device_type;
    private String protocol_type;
    private String data_format;
    private String manufacturer_name;
    private String industry;
    private String description;
    private List<ServiceCapability> service_capabilities;
    private String create_time;
    private HttpResponseResult httpResponseResult;

}
