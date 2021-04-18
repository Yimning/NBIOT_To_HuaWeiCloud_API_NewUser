package com.yimning.entity.device;

import lombok.Data;

/**
 * @program: yimning
 * @description: 修改更新设备信息
 * @author: Yimning
 * @create: 2021-04-18 17:57
 **/
@Data
public class UpdateDeviceInfo {

    private String  project_id;
    private String  device_id;
    private String device_name;
    private String description;
    private ExtensionInfo extension_info;
    private AuthInfo auth_info;
}
