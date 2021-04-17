package com.yimning.service.deviceAccess.deviceManagement.impl;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Modifying Device Shadow Information :
 * 
 * The NA can call this API to modify the configuration information to be delivered to 
 * the device on the device shadow. If the device is offline or abnormal, the NA cannot 
 * deliver configuration to the device by issuing commands. In this case, the NA can set 
 * the configuration to be delivered to the device shadow. When the device goes online 
 * again, the device shadow delivers the configuration to the device.
 */
public class ModifyDeviceShadowImpl {

	public static void main(String args[]) throws Exception {

        // Two-Way Authentication
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initSSLConfigForTwoWay();

        // Authentication.get token
        String accessToken = login(httpUtils);

        //Please make sure that the following parameter values have been modified in the Constant file.
		String appId = Constant.APPID;

        //please replace the deviceId, when you call this interface.
        String deviceId = "0be6a1d4-1a0e-410a-bf57-7d81cf31da5a";
        String urlModifyDeviceShadow = Constant.MODIFY_DEVICE_SHADOW + "/" + deviceId;

        //please replace the following parameter values, when you call this interface.
        //The value of serviceId must be consistent with the serviceId of profile that have been preset to IoT platform.
        //The value of desired must be consistent with the properties of profile that have been preset to IoT platform.
        String serviceId= "Temperature";
        ObjectNode desired = JsonUtils.convertObject2ObjectNode("{\"targetTemperature\":\"35\"}");
        
        Map<String, Object> ServiceDesiredDTO = new HashMap<>();
        ServiceDesiredDTO.put("serviceId", serviceId);
        ServiceDesiredDTO.put("desired", desired);
        
        List<Map<String, Object>> serviceDesireds = new ArrayList<Map<String, Object>>();
        serviceDesireds.add(ServiceDesiredDTO);
        
        Map<String, Object> paramModifyDeviceShadow = new HashMap<>();
        paramModifyDeviceShadow.put("serviceDesireds", serviceDesireds);

        String jsonRequest = JsonUtils.jsonObj2Sting(paramModifyDeviceShadow);

        Map<String, String> header = new HashMap<>();
        header.put(Constant.HEADER_APP_KEY, appId);
        header.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);

        StreamClosedHttpResponse responseModifyDeviceShadow = httpUtils.doPutJsonGetStatusLine(urlModifyDeviceShadow,
                header, jsonRequest);

        System.out.println("ModifyDeviceShadow, response content:");
        System.out.println(responseModifyDeviceShadow.getStatusLine());
        System.out.println(responseModifyDeviceShadow.getContent());
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