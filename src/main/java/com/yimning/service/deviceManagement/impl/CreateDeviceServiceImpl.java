package com.yimning.service.deviceManagement.impl;

import com.alibaba.fastjson.JSONObject;
import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.device.AddDevice;
import com.yimning.entity.device.AddDeviceResponse;
import com.yimning.entity.device.AuthInfo;
import com.yimning.entity.project.ProjectsID;
import com.yimning.service.auth.Authentication;
import com.yimning.service.deviceManagement.CreateDeviceService;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CreateDeviceServiceImpl implements CreateDeviceService {
    @Override
    public AddDeviceResponse createDevice(AddDevice addDevice) throws Exception {
        String token = Authentication.getToken();
//        AuthInfo authInfo = new AuthInfo();
//
//        authInfo.setAuth_type("SECRET");
//        authInfo.setSecret("123456678");
//        authInfo.setSecure_access(true);
//        authInfo.setTimeout(300);
//
//        addDevice.setAuth_info(authInfo);
//        addDevice.setDescription("test device");
//        addDevice.setDevice_name("test_deviceName2");
//        addDevice.setNode_id("1111222223333444");
//        addDevice.setProduct_id("5e09f371334dd4f337056da0");

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", Constant.Content_Type);
        headers.put("X-Auth-Token", token);

        String url = Constant.CREATE_DEVICE;
        if (addDevice.getProject_id() != null)
            url = String.format(url, addDevice.getProject_id());
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();
        StreamClosedHttpResponse httpResponse = httpUtils.doPostJsonGetStatusLine(url, headers, JsonUtils.jsonObj2Sting(addDevice));

        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getContent());
        System.out.println();

        HttpResponseResult httpResponseResult = new HttpResponseResult();
        AddDeviceResponse addDeviceResponse = new AddDeviceResponse();
        if (httpResponse.getStatusLine().getStatusCode() == 201) {
            addDeviceResponse = JSONObject.parseObject(httpResponse.getContent(), AddDeviceResponse.class);
        }else{
            httpResponseResult = JSONObject.parseObject(httpResponse.getContent(), HttpResponseResult.class);
        }
        httpResponseResult.setStatus_code(httpResponse.getStatusLine().getStatusCode());
        httpResponseResult.setReason_phrase(httpResponse.getStatusLine().getReasonPhrase());
        addDeviceResponse.setHttpResponseResult(httpResponseResult);
        return addDeviceResponse;
    }
}
