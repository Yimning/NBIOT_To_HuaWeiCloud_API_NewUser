package com.yimning.service.deviceManagements.batchTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;

/**
 * Creating a Batch Task :
 * 
 * When an NA needs to perform an operation on a batch of devices, the NA can call 
 * this API to create a batch task. Currently, the supported batch operations include 
 * delivering pending commands to devices in batches on the IoT platform.
 */
public class CreateBatchTaskController {

	public static void main(String args[]) throws Exception {

        // Two-Way Authentication
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initSSLConfigForTwoWay();

        // Authentication.get token
        String accessToken = login(httpUtils);

        //Please make sure that the following parameter values have been modified in the Constant file.
        String appId = Constant.APPID;
        String urlCreateBatchTask = Constant.CREATE_BATCH_TASK;

        //please replace the following parameter values, when you call this interface.
        Integer timeout = 60;
        String taskName = "BatchTask";
        
        /*
         * Device Cmd Task
         */
        String taskType_DeviceCmd = "DeviceCmd";

        //please replace the following parameter values, when you call this interface.
        String serviceId = "WaterMeter";
        String method = "SET_TEMPERATURE_READ_PERIOD";
        ObjectNode paras = JsonUtils.convertObject2ObjectNode("{\"value\":\"12\"}");
        
        Map<String, Object> command = new HashMap<>();
        command.put("serviceId", serviceId);
        command.put("method", method);
        command.put("paras", paras);
        
        //DeviceList|DeviceType|DeviceArea|GroupList|Broadcast|GroupIdList
        String type = "DeviceList";
        //please replace the following parameter values, when you call this interface.
        List<String> deviceList = new ArrayList<String>();
        deviceList.add("a9c09ea9-a361-4a17-a381-a07dca4c8ebf");
        
        String callbackUrl = Constant.REPORT_CMD_EXEC_RESULT_CALLBACK_URL;
        Integer maxRetransmit = 3;
        
        Map<String, Object> paramBody_DeviceCmd = new HashMap<>();
        paramBody_DeviceCmd.put("type", type);
        paramBody_DeviceCmd.put("deviceList", deviceList);
        paramBody_DeviceCmd.put("command", command);
        paramBody_DeviceCmd.put("callbackUrl", callbackUrl);
        paramBody_DeviceCmd.put("maxRetransmit", maxRetransmit);
        
        ObjectNode param_DeviceCmd = JsonUtils.convertObject2ObjectNode(paramBody_DeviceCmd);
        
        Map<String, Object> paramDeviceCmdTask = new HashMap<>();
        paramDeviceCmdTask.put("appId", appId);
        paramDeviceCmdTask.put("timeout", timeout);
        paramDeviceCmdTask.put("taskName", taskName);
        paramDeviceCmdTask.put("taskType", taskType_DeviceCmd);
        paramDeviceCmdTask.put("param", param_DeviceCmd);
        
        String jsonRequestDeviceCmdTask = JsonUtils.jsonObj2Sting(paramDeviceCmdTask);

        Map<String, String> headerDeviceCmdTask = new HashMap<>();
        headerDeviceCmdTask.put(Constant.HEADER_APP_KEY, appId);
        headerDeviceCmdTask.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);
        
        StreamClosedHttpResponse responseDeviceCmdTask = httpUtils.doPostJsonGetStatusLine(
        		urlCreateBatchTask, headerDeviceCmdTask, jsonRequestDeviceCmdTask);

        System.out.println("CreateBatchCmdTask, response content:");
        System.out.println(responseDeviceCmdTask.getStatusLine());
        System.out.println(responseDeviceCmdTask.getContent());
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
