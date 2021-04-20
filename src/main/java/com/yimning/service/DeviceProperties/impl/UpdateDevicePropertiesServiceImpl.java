package com.yimning.service.DeviceProperties.impl;

import com.alibaba.fastjson.JSONObject;
import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.DeviceProperties.UpdateDeviceProperties;
import com.yimning.entity.DeviceProperties.UpdateDevicePropertiesResponse;
import com.yimning.entity.deviceManagement.UpdateDeviceInfo;
import com.yimning.entity.deviceManagement.UpdateDeviceInfoResponse;
import com.yimning.service.DeviceProperties.UpdateDevicePropertiesService;
import com.yimning.service.auth.Authentication;
import com.yimning.service.deviceManagement.UpdateDeviceInfoService;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UpdateDevicePropertiesServiceImpl implements UpdateDevicePropertiesService {
    @Override
    public UpdateDevicePropertiesResponse updateDeviceProperties(UpdateDeviceProperties updateDeviceProperties) throws Exception {
        HttpResponseResult httpResponseResult = new HttpResponseResult();
        UpdateDevicePropertiesResponse updateDevicePropertiesResponse = new UpdateDevicePropertiesResponse();

        String token = Authentication.getToken();

        String url = Constant.UPDATE_DEVICE_PROPERTIES;
        if (updateDeviceProperties.getProject_id() != null && updateDeviceProperties.getDevice_id() != null)
            url = String.format(url, updateDeviceProperties.getProject_id(), updateDeviceProperties.getDevice_id());
        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", Constant.Content_Type);
        header.put("X-Auth-Token", token);

        //以类的方式作为参数直接修改，但deviceId不为空，也可以用其他方式。
        String paramsMap = JsonUtils.jsonObj2String(updateDeviceProperties);

        String jsonRequest = JSONObject.toJSONString(updateDeviceProperties); //属性为空时不显示

        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();

        StreamClosedHttpResponse httpResponse = httpUtils.doPutJsonGetStatusLine(url, header, paramsMap);
        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getContent());

        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            httpResponseResult = JSONObject.parseObject(httpResponse.getContent(), HttpResponseResult.class);
        } else {
            updateDevicePropertiesResponse = JSONObject.parseObject(httpResponse.getContent(), UpdateDevicePropertiesResponse.class);
        }
        httpResponseResult.setStatus_code(httpResponse.getStatusLine().getStatusCode());
        httpResponseResult.setReason_phrase(httpResponse.getStatusLine().getReasonPhrase());
        updateDevicePropertiesResponse.setHttpResponseResult(httpResponseResult);

        return updateDevicePropertiesResponse;
    }
}
