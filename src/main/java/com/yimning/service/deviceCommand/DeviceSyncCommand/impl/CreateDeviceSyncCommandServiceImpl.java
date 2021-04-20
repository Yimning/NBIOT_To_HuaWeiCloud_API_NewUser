package com.yimning.service.deviceCommand.DeviceSyncCommand.impl;

import com.alibaba.fastjson.JSONObject;
import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.deviceCommand.CreateDeviceAsyncCommand;
import com.yimning.entity.deviceCommand.CreateDeviceAsyncCommandResponse;
import com.yimning.entity.deviceCommand.CreateDeviceSyncCommand;
import com.yimning.entity.deviceCommand.CreateDeviceSyncCommandResponse;
import com.yimning.entity.deviceMessage.CreateIssueMessage;
import com.yimning.entity.deviceMessage.CreateIssueMessageResponse;
import com.yimning.service.auth.Authentication;
import com.yimning.service.deviceCommand.DeviceSyncCommand.CreateDeviceSyncCommandService;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class CreateDeviceSyncCommandServiceImpl implements CreateDeviceSyncCommandService {
    @Override
    public CreateDeviceSyncCommandResponse createDeviceSyncCommand(CreateDeviceSyncCommand createDeviceSyncCommand) throws Exception {
        HttpResponseResult httpResponseResult = new HttpResponseResult();
        CreateDeviceSyncCommandResponse createDeviceSyncCommandResponse = new CreateDeviceSyncCommandResponse();

        String token = Authentication.getToken();

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", Constant.Content_Type);
        headers.put("X-Auth-Token", token);

        String url = Constant.CREATE_ISSUE_SYNC_DEVICE_COMMAND;
        if (createDeviceSyncCommand.getProject_id() != null && createDeviceSyncCommand.getDevice_id() != null)
            url = String.format(url, createDeviceSyncCommand.getProject_id(), createDeviceSyncCommand.getDevice_id());
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();
        StreamClosedHttpResponse httpResponse = httpUtils.doPostJsonGetStatusLine(url, headers, JsonUtils.jsonObj2String(createDeviceSyncCommand));

        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getContent());
        System.out.println();

        if (httpResponse.getStatusLine().getStatusCode() == 201) {
            createDeviceSyncCommandResponse = JSONObject.parseObject(httpResponse.getContent(), CreateDeviceSyncCommandResponse.class);
        } else {
            httpResponseResult = JSONObject.parseObject(httpResponse.getContent(), HttpResponseResult.class);
        }
        httpResponseResult.setStatus_code(httpResponse.getStatusLine().getStatusCode());
        httpResponseResult.setReason_phrase(httpResponse.getStatusLine().getReasonPhrase());
        createDeviceSyncCommandResponse.setHttpResponseResult(httpResponseResult);
        return createDeviceSyncCommandResponse;
    }

}
