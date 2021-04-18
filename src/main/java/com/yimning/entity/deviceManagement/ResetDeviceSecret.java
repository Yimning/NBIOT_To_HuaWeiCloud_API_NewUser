package com.yimning.entity.deviceManagement;

import lombok.Data;

/**
 * @program: yimning
 * @description: 重置设备密钥请求参数
 * @author: Yimning
 * @create: 2021-04-18 20:48
 **/
@Data
public class ResetDeviceSecret {

    String project_id;
    String device_id;
    String action_id;//对设备执行的操作，取值范围：resetSecret。
                    //resetSecret: 重置密钥。注意：NB设备密钥由于协议特殊性，只支持十六进制密钥接入。
    private String secret;//    设备密钥，设置该字段时平台将设备密钥重置为指定值，若不设置则由平台自动生成。
    private boolean force_disconnect;//    是否强制断开设备的连接，当前仅限长连接。默认值false。
}
