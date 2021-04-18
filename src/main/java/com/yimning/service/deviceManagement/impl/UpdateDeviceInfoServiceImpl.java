package com.yimning.service.deviceManagement.impl;

import com.alibaba.fastjson.JSONObject;
import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.device.UpdateDeviceInfo;
import com.yimning.entity.device.UpdateDeviceInfoResponse;
import com.yimning.service.auth.Authentication;
import com.yimning.service.deviceManagement.UpdateDeviceInfoService;
import com.yimning.utils.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UpdateDeviceInfoServiceImpl implements UpdateDeviceInfoService {
    @Override
    public UpdateDeviceInfoResponse updateDeviceInfo(UpdateDeviceInfo updateDeviceInfo) throws Exception {
        String token = Authentication.getToken();

        String url = Constant.MODIFY_DEVICE_INFO;
        if (updateDeviceInfo.getProject_id() != null && updateDeviceInfo.getDevice_id() != null)
            url = String.format(url, updateDeviceInfo.getProject_id(), updateDeviceInfo.getDevice_id());
        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", Constant.Content_Type);
        header.put("X-Auth-Token", token);

        //以类的方式作为参数直接修改，但deviceId不为空，也可以用其他方式。
        String paramsMap = JsonUtils.jsonObj2String(updateDeviceInfo);

        String jsonRequest = JSONObject.toJSONString(updateDeviceInfo); //属性为空时不显示

        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();

        StreamClosedHttpResponse httpResponse = httpUtils.doPutJsonGetStatusLine(url, header, paramsMap);
        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getContent());
        HttpResponseResult httpResponseResult = new HttpResponseResult();
        UpdateDeviceInfoResponse updateDeviceInfoResponse = new UpdateDeviceInfoResponse();
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            httpResponseResult = JSONObject.parseObject(httpResponse.getContent(), HttpResponseResult.class);
        } else {
            updateDeviceInfoResponse = JSONObject.parseObject(httpResponse.getContent(), UpdateDeviceInfoResponse.class);
        }
        httpResponseResult.setStatus_code(httpResponse.getStatusLine().getStatusCode());
        httpResponseResult.setReason_phrase(httpResponse.getStatusLine().getReasonPhrase());
        updateDeviceInfoResponse.setHttpResponseResult(httpResponseResult);

        return updateDeviceInfoResponse;
    }
}
