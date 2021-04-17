package com.yimning.controller.deviceManagement.subscribtionManagement;

import java.util.HashMap;
import java.util.Map;

import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;

/**
 * Deleting Subscriptions in Batches :
 * 
 * If an NA does not need to receive subscription notification messages pushed by the 
 * IoT platform or a specified type of subscription notification messages, the NA can 
 * call this API to delete subscription configurations in batches to cancel the subscriptions.
 */
public class DeleteSubscriptionsController {

    public static void main(String args[]) throws Exception {

        // Two-Way Authentication
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initSSLConfigForTwoWay();

        // Authentication.get token
        String accessToken = login(httpUtils);
        
        //Please make sure that the following parameter values have been modified in the Constant file.
        String appId = Constant.APPID;
        String urlDeleteSubscriptions = Constant.DELETE_SUBSCRIPTIONS;
        
        /*
         * please replace the subscription type, when you call this interface.
         * service Notify Type:
         * deviceAdded|bindDevice|deviceInfoChanged|deviceDataChanged|deviceDatasChanged|
         * deviceDeleted|messageConfirm|commandRsp|deviceEvent|serviceInfoChanged|
         * ruleEvent|deviceModelAdded|deviceModelDeleted|
         * deviceDesiredPropertiesModifyStatusChanged
         * management Notify Type:
         * swUpgradeStateChangeNotify|swUpgradeResultNotify|fwUpgradeStateChangeNotify|fwUpgradeResultNotify
         */
        String notifyType = "swUpgradeStateChangeNotify";
        
        Map<String, String> paramDeleteSubscriptions = new HashMap<>();
        paramDeleteSubscriptions.put("notifyType", notifyType);
        
        Map<String, String> header = new HashMap<>();
        header.put(Constant.HEADER_APP_KEY, appId);
        header.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);

        StreamClosedHttpResponse responseDeleteSubscriptions = httpUtils.doDeleteWithParasGetStatusLine(
        		urlDeleteSubscriptions, paramDeleteSubscriptions, header);

        System.out.println("DeleteSubscriptions, response content:");
        System.out.println(responseDeleteSubscriptions.getStatusLine());
        System.out.println(responseDeleteSubscriptions.getContent());
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
