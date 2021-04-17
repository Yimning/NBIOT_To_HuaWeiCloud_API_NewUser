package com.yimning.service.deviceManagements.deviceUpgrade;

import java.util.HashMap;
import java.util.Map;

import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;

/**
 * Query Specify Upgrade Task Result :
 * After a device software or firmware upgrade task is created, 
 * an NA can call this interface to query details about the upgrade task.
 */
public class QuerySpecifyUpgradeTaskResult {

	public static void main(String args[]) throws Exception {

        // Two-Way Authentication
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initSSLConfigForTwoWay();

        // Authentication.get token
        String accessToken = login(httpUtils);

        //please replace the operationId, when you call this interface.
        String operationId = "5c00ad65f7b537019b440a4a";
        
        //Please make sure that the following parameter values have been modified in the Constant file.
		String appId = Constant.APPID;
        String urlQuerySpecifyUpgradeTaskResult = Constant.QUERY_SPECIFY_UPGRADE_TASK_RESULT + "/" + operationId;

        Map<String, String> header = new HashMap<>();
        header.put(Constant.HEADER_APP_KEY, appId);
        header.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);

        StreamClosedHttpResponse responseQuerySpecifyUpgradeTaskResult = httpUtils.doGetWithParasGetStatusLine(urlQuerySpecifyUpgradeTaskResult, null, header);

        System.out.println("QuerySpecifyUpgradeTaskResult, response content:");
        System.out.println(responseQuerySpecifyUpgradeTaskResult.getStatusLine());
        System.out.println(responseQuerySpecifyUpgradeTaskResult.getContent());
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
