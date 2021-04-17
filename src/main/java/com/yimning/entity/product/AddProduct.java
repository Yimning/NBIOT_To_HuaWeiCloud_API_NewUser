package com.yimning.entity.product;

import com.yimning.common.lang.HttpResponseResult;
import lombok.Data;

import java.util.List;

@Data
public class AddProduct {
     private String project_id;
     private String product_id;
     private String name;
     private String device_type;
     private String protocol_type;
     private String data_format;
     private String manufacturer_name;
     private String industry;
     private String description;
     private List<ServiceCapability> service_capabilities;
     private String app_id;
     private HttpResponseResult httpResponseResult;

}
