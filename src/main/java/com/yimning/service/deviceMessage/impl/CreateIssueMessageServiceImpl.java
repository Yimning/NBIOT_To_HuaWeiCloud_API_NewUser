package com.yimning.service.deviceMessage.impl;

import com.alibaba.fastjson.JSONObject;
import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.deviceManagement.AddDevice;
import com.yimning.entity.deviceManagement.AddDeviceResponse;
import com.yimning.entity.deviceMessage.CreateIssueMessage;
import com.yimning.entity.deviceMessage.CreateIssueMessageResponse;
import com.yimning.service.auth.Authentication;
import com.yimning.service.deviceManagement.CreateDeviceService;
import com.yimning.service.deviceMessage.CreateIssueMessageService;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CreateIssueMessageServiceImpl implements CreateIssueMessageService {

    @Override
    public CreateIssueMessageResponse createIssueMessage(CreateIssueMessage createIssueMessage) throws Exception {
        HttpResponseResult httpResponseResult = new HttpResponseResult();
        CreateIssueMessageResponse createIssueMessageResponse = new CreateIssueMessageResponse();

        String token = Authentication.getToken();

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", Constant.Content_Type);
        headers.put("X-Auth-Token", token);

        String url = Constant.ISSUE_DEVICE_MESSAGE;
        if (createIssueMessage.getProject_id() != null && createIssueMessage.getDevice_id()!=null )
            url = String.format(url, createIssueMessage.getProject_id(),createIssueMessage.getDevice_id());
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();
        StreamClosedHttpResponse httpResponse = httpUtils.doPostJsonGetStatusLine(url, headers, JsonUtils.jsonObj2String(createIssueMessage));

        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getContent());
        System.out.println();

        if (httpResponse.getStatusLine().getStatusCode() == 201) {
            createIssueMessageResponse = JSONObject.parseObject(httpResponse.getContent(), CreateIssueMessageResponse.class);
        }else{
            httpResponseResult = JSONObject.parseObject(httpResponse.getContent(), HttpResponseResult.class);
        }
        httpResponseResult.setStatus_code(httpResponse.getStatusLine().getStatusCode());
        httpResponseResult.setReason_phrase(httpResponse.getStatusLine().getReasonPhrase());
        createIssueMessageResponse.setHttpResponseResult(httpResponseResult);
        return createIssueMessageResponse;
    }
}
