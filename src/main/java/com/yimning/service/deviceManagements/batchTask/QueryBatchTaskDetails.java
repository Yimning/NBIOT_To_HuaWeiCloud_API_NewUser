package com.yimning.service.deviceManagements.batchTask;

import java.util.HashMap;
import java.util.Map;

import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;

/**
 * Querying Information About a Subtask of a Batch Task :
 * 
 * After creating a batch task for devices, an NA can call this API to query information 
 * about a subtask of the batch task, including the subtask execution status and subtask content.
 */
public class QueryBatchTaskDetails {

    public static void main(String args[]) throws Exception {

        // Two-Way Authentication
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initSSLConfigForTwoWay();

        // Authentication.get token
        String accessToken = login(httpUtils);

        //Please make sure that the following parameter values have been modified in the Constant file.
        String appId = Constant.APPID;
        String urlQueryBatchTaskDetails = Constant.QUERY_BATCH_TASK_DETAILS;

        //please replace the taskId, when you call this interface.
        String taskId = "5c26d34878965909ca44c1f0";

        Map<String, String> paramQueryBatchTaskDetails = new HashMap<>();
        paramQueryBatchTaskDetails.put("taskId", taskId);

        Map<String, String> header = new HashMap<>();
        header.put(Constant.HEADER_APP_KEY, appId);
        header.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);
        
        StreamClosedHttpResponse ResponseQueryBatchTaskDetails = httpUtils.doGetWithParasGetStatusLine(urlQueryBatchTaskDetails,
        		paramQueryBatchTaskDetails, header);

        System.out.println("QueryBatchTaskDetails, response content:");
        System.out.println(ResponseQueryBatchTaskDetails.getStatusLine());
        System.out.println(ResponseQueryBatchTaskDetails.getContent());
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
