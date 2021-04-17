package com.yimning.service.deviceAccess.appAccessSecurity;

import java.util.HashMap;
import java.util.Map;

import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;

/**
 *  Refreshing a Token :
 *  
 *  An access token obtained by calling the Authentication API has a valid time. 
 *  When the access token is about to expire, an NA can call this API to obtain 
 *  a new access token.
 */
public class RefreshToken {

    public static void main(String args[]) throws Exception {

        // Two-Way Authentication
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initSSLConfigForTwoWay();

        // get refreshToken
        String refreshToken = getRefreshToken(httpUtils);
        String appId = Constant.APPID;
        String secret = Constant.SECRET;
        String urlRefreshToken = Constant.REFRESH_TOKEN; 

        Map<String, Object> param_reg = new HashMap<>();
        param_reg.put("appId", appId);
        param_reg.put("secret", secret);
        param_reg.put("refreshToken", refreshToken);

        String jsonRequest = JsonUtils.jsonObj2Sting(param_reg);
        StreamClosedHttpResponse bodyRefreshToken = httpUtils.doPostJsonGetStatusLine(urlRefreshToken, jsonRequest);

        System.out.println("RefreshToken, response content:");
        System.out.println(bodyRefreshToken.getStatusLine());
        System.out.println(bodyRefreshToken.getContent());
        System.out.println();
    }

    /**
     * get refreshToken
     */
    @SuppressWarnings("unchecked")
    public static String getRefreshToken(HttpUtils httpUtils) throws Exception {

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
        return data.get("refreshToken");
    }
}
