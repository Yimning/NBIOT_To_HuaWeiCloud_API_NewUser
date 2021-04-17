package com.yimning.service.deviceManagements.subscribtionManagement;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;

import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;

/**
 * Subscribing to Service Data :
 * 
 * An NA can subscribe to service data of a device on the IoT platform. When the service data 
 * changes (for example, the device is registered, the device reports data or the device status 
 * changes), the IoT platform can push change notifications to the NA.
 */
public class SubscribeServiceNotification {

    public static void main(String args[]) throws Exception {

        // Two-Way Authentication
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initSSLConfigForTwoWay();

        // Authentication.get token
        String accessToken = login(httpUtils);

        //Please make sure that the following parameter values have been modified in the Constant file.
        String appId = Constant.APPID;
        String urlSubscribeServiceNotification = Constant.SUBSCRIBE_SERVICE_NOTIFYCATION;

        /*
         * please replace the notifyType, when you call this interface.
         * service Notify Type:
         * deviceAdded|bindDevice|deviceInfoChanged|deviceDataChanged|deviceDatasChanged|
         * deviceDeleted|messageConfirm|commandRsp|deviceEvent|serviceInfoChanged|
         * ruleEvent|deviceModelAdded|deviceModelDeleted|
         * deviceDesiredPropertiesModifyStatusChanged
         */
        String notifyType = "deviceAdded";
        
        //Please make sure that the value of callbackurl have been modified in the Constant file.
        //And choose the callbackurl according to the notifyType.
        String callbackurl = Constant.DEVICE_ADDED_CALLBACK_URL;
        
        Map<String, Object> paramSubscribe = new HashMap<>();
        paramSubscribe.put("notifyType", notifyType);
        paramSubscribe.put("callbackUrl", callbackurl);
        paramSubscribe.put("appId", appId);

        String jsonRequest = JsonUtils.jsonObj2Sting(paramSubscribe);

        Map<String, String> header = new HashMap<>();
        header.put(Constant.HEADER_APP_KEY, appId);
        header.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);

        HttpResponse httpResponse = httpUtils.doPostJson(urlSubscribeServiceNotification, header, jsonRequest);

        String bodySubscribe = httpUtils.getHttpResponseBody(httpResponse);

        System.out.println("SubscribeServiceNotification: " + notifyType + ", response content:");
        System.out.println(httpResponse.getStatusLine());
        System.out.println(bodySubscribe);
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
