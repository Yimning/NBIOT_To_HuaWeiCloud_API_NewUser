package com.yimning.service.deviceManagements.deviceUpgrade;

import java.util.HashMap;
import java.util.Map;

import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;

/**
 * Query Upgrade Tasks :
 * This interface is used to query details about upgrade tasks that meet specified conditions.
 */
public class QueryUpgradeTasks {

	public static void main(String args[]) throws Exception {

        // Two-Way Authentication
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initSSLConfigForTwoWay();

        // Authentication.get token
        String accessToken = login(httpUtils);

        //Please make sure that the following parameter values have been modified in the Constant file.
		String appId = Constant.APPID;
        String urlQueryUpgradeTasks = Constant.QUERY_UPGRADE_TASKS;
        
        //please replace the pageSize and operationType(firmware_upgrade|software_upgrade), when you call this interface.
        Integer pageSize = 100;
        String operationType = "firmware_upgrade";
        
        Map<String, String> paramQueryUpgradeTasks = new HashMap<>();
        paramQueryUpgradeTasks.put("pageSize", pageSize.toString());
        paramQueryUpgradeTasks.put("operationType", operationType);

        Map<String, String> header = new HashMap<>();
        header.put(Constant.HEADER_APP_KEY, appId);
        header.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);

        StreamClosedHttpResponse responseQueryUpgradeTasks = 
        		httpUtils.doGetWithParasGetStatusLine(urlQueryUpgradeTasks, paramQueryUpgradeTasks, header);

        System.out.println("QueryUpgradeTasks, response content:");
        System.out.println(responseQueryUpgradeTasks.getStatusLine());
        System.out.println(responseQueryUpgradeTasks.getContent());
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
