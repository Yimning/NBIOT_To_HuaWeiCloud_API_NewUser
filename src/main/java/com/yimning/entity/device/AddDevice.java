package com.yimning.entity.device;

import lombok.Data;

import java.util.List;

@Data
public class AddDevice {
    private String project_id;

    private String device_id;
    private String device_name;
    private String node_id;
    private String product_id;
    private AuthInfo auth_info;
    private String description;
    private String gateway_id;
    private String app_id;
    private ExtensionInfo extension_info;
    private List<InitialDesired> shadow;
}
