package com.yimning.service.deviceCommand.DeviceAsyncCommand.impl;


import com.alibaba.fastjson.JSONObject;
import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.deviceCommand.CreateDeviceAsyncCommand;
import com.yimning.entity.deviceCommand.CreateDeviceAsyncCommandResponse;
import com.yimning.entity.deviceCommand.CreateDeviceAsyncCommandResponse;
import com.yimning.service.auth.Authentication;
import com.yimning.service.deviceCommand.DeviceAsyncCommand.CreateDeviceAsyncCommandService;
import com.yimning.service.deviceCommand.DeviceAsyncCommand.CreateDeviceAsyncCommandService;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class CreateDeviceAsyncCommandServiceImpl implements CreateDeviceAsyncCommandService {

    @Override
    public CreateDeviceAsyncCommandResponse createDeviceAsyncCommand(CreateDeviceAsyncCommand createDeviceAsyncCommand) throws Exception {
        HttpResponseResult httpResponseResult = new HttpResponseResult();
        CreateDeviceAsyncCommandResponse createDeviceAsyncCommandResponse = new CreateDeviceAsyncCommandResponse();

        String token = Authentication.getToken();

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", Constant.Content_Type);
        headers.put("X-Auth-Token", token);

        String url = Constant.CREATE_ISSUE_ASYNC_DEVICE_COMMAND;
        if (createDeviceAsyncCommand.getProject_id() != null && createDeviceAsyncCommand.getDevice_id() != null)
            url = String.format(url, createDeviceAsyncCommand.getProject_id(), createDeviceAsyncCommand.getDevice_id());
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();
        StreamClosedHttpResponse httpResponse = httpUtils.doPostJsonGetStatusLine(url, headers, JsonUtils.jsonObj2String(createDeviceAsyncCommand));

        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getContent());
        System.out.println();

        if (httpResponse.getStatusLine().getStatusCode() == 201) {
            createDeviceAsyncCommandResponse = JSONObject.parseObject(httpResponse.getContent(), CreateDeviceAsyncCommandResponse.class);
        } else {
            httpResponseResult = JSONObject.parseObject(httpResponse.getContent(), HttpResponseResult.class);
        }
        httpResponseResult.setStatus_code(httpResponse.getStatusLine().getStatusCode());
        httpResponseResult.setReason_phrase(httpResponse.getStatusLine().getReasonPhrase());
        createDeviceAsyncCommandResponse.setHttpResponseResult(httpResponseResult);
        return createDeviceAsyncCommandResponse;
    }
}
