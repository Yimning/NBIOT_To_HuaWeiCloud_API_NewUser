package com.yimning.entity.deviceCommand;

import com.yimning.common.lang.HttpResponseResult;
import lombok.Data;

/**
 * @program: yimning
 * @description: 设备同步命令响应结果
 * @author: Yimning
 * @create: 2021-04-20 14:53
 **/
@Data
public class CreateDeviceSyncCommandResponse {
    private String command_id;
    private Response response;
    private HttpResponseResult httpResponseResult;
}
