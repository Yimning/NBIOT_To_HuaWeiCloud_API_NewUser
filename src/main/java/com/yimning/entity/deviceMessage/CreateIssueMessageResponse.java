package com.yimning.entity.deviceMessage;

import com.yimning.common.lang.HttpResponseResult;
import lombok.Data;

/**
 * @program: yimning
 * @description: 创建下发设备消息响应结果
 * @author: Yimning
 * @create: 2021-04-19 14:46
 **/
@Data
public class CreateIssueMessageResponse {

    private String message_id;
    private MessageResult result;
    private HttpResponseResult httpResponseResult;
}
