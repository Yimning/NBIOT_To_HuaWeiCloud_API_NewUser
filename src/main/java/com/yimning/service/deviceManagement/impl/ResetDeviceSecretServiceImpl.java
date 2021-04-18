package com.yimning.service.deviceManagement.impl;

import com.alibaba.fastjson.JSONObject;
import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.device.ResetDeviceSecret;
import com.yimning.entity.device.ResetDeviceSecretResponse;
import com.yimning.service.auth.Authentication;
import com.yimning.service.deviceManagement.ResetDeviceSecretService;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ResetDeviceSecretServiceImpl implements ResetDeviceSecretService {

    @Override
    public ResetDeviceSecretResponse resetDeviceSecret(ResetDeviceSecret resetDeviceSecret) throws Exception {
        String token = Authentication.getToken();
        ResetDeviceSecretResponse resetDeviceSecretResponse = new ResetDeviceSecretResponse();
        HttpResponseResult httpResponseResult = new HttpResponseResult();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", Constant.Content_Type);
        headers.put("X-Auth-Token", token);

        String url = Constant.RESET_DEVICE_SECRET;
        String action_id_default = "resetSecret";
        if (resetDeviceSecret.getProject_id() != null && resetDeviceSecret.getDevice_id() != null)
            url = String.format(url, resetDeviceSecret.getProject_id(), resetDeviceSecret.getDevice_id());
        else {
            httpResponseResult.setStatus_code(403);
            httpResponseResult.setError_msg("项目ID或设备ID为空");
            resetDeviceSecretResponse.setHttpResponseResult(httpResponseResult);
            return resetDeviceSecretResponse;
        }
        if (resetDeviceSecret.getAction_id() != null)
            url = url + "?action_id=" + resetDeviceSecret.getAction_id();
        else url = url + "?action_id=" + action_id_default;
        System.out.println(url);
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();
        StreamClosedHttpResponse httpResponse = httpUtils.doPostJsonGetStatusLine(url, headers, JsonUtils.jsonObj2String(resetDeviceSecret));

        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getContent());
        System.out.println();


        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            resetDeviceSecretResponse = JSONObject.parseObject(httpResponse.getContent(), ResetDeviceSecretResponse.class);
        } else {
            httpResponseResult = JSONObject.parseObject(httpResponse.getContent(), HttpResponseResult.class);
        }
        httpResponseResult.setStatus_code(httpResponse.getStatusLine().getStatusCode());
        httpResponseResult.setReason_phrase(httpResponse.getStatusLine().getReasonPhrase());
        resetDeviceSecretResponse.setHttpResponseResult(httpResponseResult);
        return resetDeviceSecretResponse;
    }
}
