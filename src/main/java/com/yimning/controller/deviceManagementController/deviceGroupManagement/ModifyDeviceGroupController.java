package com.yimning.service.deviceManagements.deviceGroupManagement;

import java.util.HashMap;
import java.util.Map;

import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;

/**
 * Modify Device Group :
 * This interface is used to modify information about a specified device group on the IoT platform.
 */
public class ModifyDeviceGroupController {

    public static void main(String[] args) throws Exception {

        // Two-Way Authentication
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initSSLConfigForTwoWay();

        // Authentication.get token
        String accessToken = login(httpUtils);
        
        //please replace the devGroupId, when you call this interface.
        String devGroupId = "e8b8edce-7e08-4131-b3e5-c78351e62dc2";

        //Please make sure that the following parameter values have been modified in the Constant file.
        String urlModifyDeviceGroup = Constant.MODIFY_DEVICE_GROUP + "/" + devGroupId;
        String appId = Constant.APPID;
        
        //please replace the following parameter values, when you call this interface.
        String name = "Group001";
        int maxDevNum = 200;

        Map<String, Object> paramModifyDeviceGroup = new HashMap<>();
        paramModifyDeviceGroup.put("name", name);
        paramModifyDeviceGroup.put("maxDevNum", maxDevNum);
        
        String jsonRequest = JsonUtils.jsonObj2Sting(paramModifyDeviceGroup);
                
        Map<String, String> header = new HashMap<>();
        header.put(Constant.HEADER_APP_KEY, appId);
        header.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);
        
        StreamClosedHttpResponse responseModifyDeviceGroup = httpUtils.doPutJsonGetStatusLine(urlModifyDeviceGroup, header, jsonRequest);

        System.out.println("ModifyDeviceGroup, response content:");
        System.out.println(responseModifyDeviceGroup.getStatusLine());
        System.out.println(responseModifyDeviceGroup.getContent());
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
