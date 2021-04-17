package com.yimning.entity.product;

import lombok.Data;

import java.util.List;
@Data
public class ServiceCapability {
    private String service_id;
    private String service_type;
    private List<Properties> properties;
    private List<Commands> commands;
    private String description;
    private String option;

}
