package com.yimning.entity.product;

import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.QueryDeviceCapabilities;
import lombok.Data;

import java.util.List;

/**
 * @program: yimning
 * @description: 修改产品
 * @author: Yimning
 * @create: 2021-04-17 17:06
 **/
@Data
public class ModifyProduct {
    private String project_id;
    private String product_id;

    private String app_id;
    private String name;
    private String device_type;
    private String protocol_type;
    private String data_format;
    private List<ServiceCapability> service_capabilities;
    private String manufacturer_name;
    private String industry;
    private String description;
    private HttpResponseResult httpResponseResult;
}
