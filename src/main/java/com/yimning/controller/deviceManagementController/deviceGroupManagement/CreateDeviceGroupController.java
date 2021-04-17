package com.yimning.service.deviceManagements.deviceGroupManagement;

import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create Device Group :
 * This interface is used to create a device group for managing devices by group on the IoT platform.
 */
public class CreateDeviceGroupController {

    public static void main(String[] args) throws Exception {

        // Two-Way Authentication
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initSSLConfigForTwoWay();

        // Authentication.get token
        String accessToken = login(httpUtils);

        //Please make sure that the following parameter values have been modified in the Constant file.
        String urlCreateDeviceGroup = Constant.CREATE_DEVICE_GROUP;
        String appId = Constant.APPID;
        
        //please replace the following parameter values, when you call this interface.
        String name = "Group01";
        Integer maxDevNum = 100;
        List<String> deviceIds = new ArrayList<String>();
        deviceIds.add("de71ad4a-211e-4e53-b48c-80cb2d5c88c8");
      
        Map<String, Object> paramCreateDeviceGroup = new HashMap<>();
        paramCreateDeviceGroup.put("name", name);
        paramCreateDeviceGroup.put("maxDevNum", maxDevNum);
        paramCreateDeviceGroup.put("deviceIds", deviceIds);
        
        String jsonRequest = JsonUtils.jsonObj2Sting(paramCreateDeviceGroup);
                
        Map<String, String> header = new HashMap<>();
        header.put(Constant.HEADER_APP_KEY, appId);
        header.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);
        
        StreamClosedHttpResponse responseCreateDeviceGroup = httpUtils.doPostJsonGetStatusLine(urlCreateDeviceGroup, header, jsonRequest);

        System.out.println("CreateDeviceGroup, response content:");
        System.out.println(responseCreateDeviceGroup.getStatusLine());
        System.out.println(responseCreateDeviceGroup.getContent());
        System.out.println();
    }

    /**
     * Authentication.get token
     */
    @SuppressWarnings("unchecked")
    public static String login(HttpUtils httpUtils) throws Exception {

        String appId = Constant.APPID;
        String secret = Constant.SECRET;
        String urlLogin = Constant.APP_AUTH;

        Map<String, String> paramLogin = new HashMap<>();
        paramLogin.put("appId", appId);
        paramLogin.put("secret", secret);

        StreamClosedHttpResponse responseLogin = httpUtils.doPostFormUrlEncodedGetStatusLine(urlLogin, paramLogin);

        System.out.println("app auth success,return accessToken:");
        System.out.println(responseLogin.getStatusLine());
        System.out.println(responseLogin.getContent());
        System.out.println();

        Map<String, String> data = new HashMap<>();
        data = JsonUtils.jsonString2SimpleObj(responseLogin.getContent(), data.getClass());
        return data.get("accessToken");
    }

}
