package com.yimning.service.deviceCommand.DeviceAsyncCommand.impl;


import com.alibaba.fastjson.JSONObject;
import com.yimning.common.lang.HttpResponseResult;

import com.yimning.entity.deviceCommand.QueryDeviceAsyncCommandByCommandID;
import com.yimning.entity.deviceCommand.QueryDeviceAsyncCommandByCommandIDResponse;
import com.yimning.service.auth.Authentication;
import com.yimning.service.deviceCommand.DeviceAsyncCommand.QueryDeviceAsyncCommandByCommandIDService;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.StreamClosedHttpResponse;
import com.yimning.utils.TypeConversionUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 *  
 *
 * @Description: 查询某个设备命令  project_id不能为空
 * @Param:  
 * @return:  
 * @Author: Yimning
 * @Date: 2021/4/17 
 */
@Service
public class QueryDeviceAsyncCommandByCommandIDServiceImpl implements QueryDeviceAsyncCommandByCommandIDService {
    @Override
    public QueryDeviceAsyncCommandByCommandIDResponse queryDeviceAsyncCommandByCommandID(QueryDeviceAsyncCommandByCommandID queryDeviceAsyncCommandByCommandID) throws Exception {
        QueryDeviceAsyncCommandByCommandIDResponse queryDeviceAsyncCommandByCommandIDResponse = new QueryDeviceAsyncCommandByCommandIDResponse();
        HttpResponseResult httpResponseResult = new HttpResponseResult();

        String token = Authentication.getToken();
        String url = Constant.QUERY_DEVICE_MESSAGE_BY_MESSAGEID;
        if (queryDeviceAsyncCommandByCommandID.getProject_id() != null && queryDeviceAsyncCommandByCommandID.getDevice_id() != null && queryDeviceAsyncCommandByCommandID.getCommand_id() != null)
            url = String.format(url, queryDeviceAsyncCommandByCommandID.getProject_id(), queryDeviceAsyncCommandByCommandID.getDevice_id(), queryDeviceAsyncCommandByCommandID.getCommand_id());

        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", "application/json");
        header.put("X-Auth-Token", token);
        Map paramsMap = TypeConversionUtils.getObjectToValMap(queryDeviceAsyncCommandByCommandID, false);
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();
        StreamClosedHttpResponse httpResponse = httpUtils.doGetWithParasGetStatusLine(url, header, paramsMap);

        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getContent());
        System.out.println();

        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            httpResponseResult = JSONObject.parseObject(httpResponse.getContent(), HttpResponseResult.class);
        } else if (httpResponse.getContent() != null) {
            queryDeviceAsyncCommandByCommandIDResponse = JSONObject.parseObject(httpResponse.getContent(), QueryDeviceAsyncCommandByCommandIDResponse.class);
        }
        httpResponseResult.setStatus_code(httpResponse.getStatusLine().getStatusCode());
        queryDeviceAsyncCommandByCommandIDResponse.setHttpResponseResult(httpResponseResult);
        return queryDeviceAsyncCommandByCommandIDResponse;
    }
}
