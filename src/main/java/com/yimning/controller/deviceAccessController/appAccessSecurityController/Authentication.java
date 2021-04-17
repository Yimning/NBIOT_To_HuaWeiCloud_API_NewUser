package com.yimning.controller.deviceAccessController.appAccessSecurityController;

import java.util.HashMap;
import java.util.Map;

import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;

/**
 *  Authentication:
 *  
 *  This API is called by an NA for access authentication when the NA accesses 
 *  open APIs of the IoT platform for the first time. After the authentication 
 *  of the NA expires, the NA must call this API to perform authentication again 
 *  so that the NA can continue to access open APIs of the IoT platform. 
 */
public class Authentication {
    @SuppressWarnings("unchecked")
	public static void main(String args[]) throws Exception {

        // Two-Way Authentication
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initSSLConfigForTwoWay();

        //Please make sure that the following parameter values have been modified in the Constant file.
        String appId = Constant.APPID;
        String secret = Constant.SECRET;
        String urlLogin = Constant.APP_AUTH;

        Map<String, String> param = new HashMap<>();
        param.put("appId", appId);
        param.put("secret", secret);

        StreamClosedHttpResponse responseLogin = httpUtils.doPostFormUrlEncodedGetStatusLine(urlLogin, param);

        System.out.println("app auth success,return accessToken:");
        System.out.println(responseLogin.getStatusLine());
        System.out.println(responseLogin.getContent());
        System.out.println();

        //resolve the value of accessToken from responseLogin.
        Map<String, String> data = new HashMap<>();
        data = JsonUtils.jsonString2SimpleObj(responseLogin.getContent(), data.getClass());
        String accessToken = data.get("accessToken");
        System.out.println("accessToken:" + accessToken);

    }
}
