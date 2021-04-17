package com.service.deviceManagement.deviceUpgrade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;

/**
 * Create Software Upgrade Task :
 * This interface is used to create a software upgrade task for multiple devices on the IoT platform.
 * Currently, only the software of NB-IoT devices can be upgraded.
 */
public class CreateSWUpgradeTaskController {

	public static void main(String args[]) throws Exception {

        // Two-Way Authentication
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initSSLConfigForTwoWay();

        // Authentication.get token
        String accessToken = login(httpUtils);

        //Please make sure that the following parameter values have been modified in the Constant file.
		String appId = Constant.APPID;        
        String urlCreateSWUpgradeTask = Constant.CREATE_SW_UPGRADE_TASK;
        
        //please replace the fileId, when you call this interface.
        String fileId = "6a5b8658abf5adbae6de914b";
        
        //please replace the deviceId, when you call this interface.
        ArrayList<String> devices = new ArrayList<String>();
        devices.add("9e620731-9a8b-42b7-b685-263546b74afc");
        
        Map<String, Object> operateDevices = new HashMap<>();
        operateDevices.put("devices", devices);
        
        /*
         * executeType:
         * now|device_online|custom
         */
        String executeType = "now";
        
        Map<String, Object> operatePolicy = new HashMap<>();
        operatePolicy.put("executeType", executeType);
        
        Map<String, Object> paramCreateSWUpgradeTask = new HashMap<>();
        paramCreateSWUpgradeTask.put("fileId", fileId);
        paramCreateSWUpgradeTask.put("targets", operateDevices);
        paramCreateSWUpgradeTask.put("policy", operatePolicy);
        
        String jsonRequest = JsonUtils.jsonObj2Sting(paramCreateSWUpgradeTask);

        Map<String, String> header = new HashMap<>();
        header.put(Constant.HEADER_APP_KEY, appId);
        header.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);

        StreamClosedHttpResponse responseCreateSWUpgradeTask = httpUtils.doPostJsonGetStatusLine(urlCreateSWUpgradeTask, header, jsonRequest);

        System.out.println("CreateFWUpgradeTask, response content:");
        System.out.println(responseCreateSWUpgradeTask.getStatusLine());
        System.out.println(responseCreateSWUpgradeTask.getContent());
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
