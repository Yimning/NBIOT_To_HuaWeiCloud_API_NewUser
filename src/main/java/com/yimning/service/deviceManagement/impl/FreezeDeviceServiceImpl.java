package com.yimning.service.deviceManagement.impl;

import com.alibaba.fastjson.JSONObject;
import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.deviceManagement.FreezeDevice;
import com.yimning.service.auth.Authentication;
import com.yimning.service.deviceManagement.FreezeDeviceService;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FreezeDeviceServiceImpl implements FreezeDeviceService {
    @Override
    public HttpResponseResult freezeDevice(FreezeDevice freezeDevice) throws Exception {
        HttpResponseResult httpResponseResult = new HttpResponseResult();
        String token = Authentication.getToken();

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", Constant.Content_Type);
        headers.put("X-Auth-Token", token);

        String url = Constant.FREEZE_DEVICE;
        if (freezeDevice.getProject_id() != null && freezeDevice.getDevice_id() != null)
            url = String.format(url, freezeDevice.getProject_id(),freezeDevice.getDevice_id());
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();
        StreamClosedHttpResponse httpResponse = httpUtils.doPostJsonGetStatusLine(url, headers, JsonUtils.jsonObj2String(freezeDevice));

        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getContent());
        System.out.println();

        if (httpResponse.getContent() != null)
            httpResponseResult = JSONObject.parseObject(httpResponse.getContent(), HttpResponseResult.class);
        else {
            httpResponseResult.setReason_phrase("No Content");
        }
        httpResponseResult.setStatus_code(httpResponse.getStatusLine().getStatusCode());

        return httpResponseResult;
    }
}
