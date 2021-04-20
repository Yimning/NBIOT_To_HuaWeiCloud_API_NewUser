package com.yimning.service.deviceMessage.impl;


import com.alibaba.fastjson.JSONObject;
import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.deviceMessage.QueryDeviceMessageByID;
import com.yimning.entity.deviceMessage.QueryDeviceMessageByIDResponse;
import com.yimning.service.auth.Authentication;
import com.yimning.service.deviceMessage.QueryDeviceMessageByIDService;
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
 * @Description: 查询某个设备消息 project_id不能为空
 * @Param:  
 * @return:  
 * @Author: Yimning
 * @Date: 2021/4/17 
 */
@Service
public class QueryDeviceMessageByIDServiceImpl implements QueryDeviceMessageByIDService {
    @Override
    public QueryDeviceMessageByIDResponse queryDeviceMessageByID(QueryDeviceMessageByID queryDeviceMessageByID) throws Exception {
        QueryDeviceMessageByIDResponse queryDeviceMessageByIDResponse = new QueryDeviceMessageByIDResponse();
        HttpResponseResult httpResponseResult = new HttpResponseResult();

        String token = Authentication.getToken();
        String url = Constant.QUERY_DEVICE_MESSAGE_BY_MESSAGEID;
        if (queryDeviceMessageByID.getProject_id() != null && queryDeviceMessageByID.getDevice_id() != null && queryDeviceMessageByID.getMessage_id() != null)
            url = String.format(url, queryDeviceMessageByID.getProject_id(), queryDeviceMessageByID.getDevice_id(), queryDeviceMessageByID.getMessage_id());

        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", "application/json");
        header.put("X-Auth-Token", token);
        Map paramsMap = TypeConversionUtils.getObjectToValMap(queryDeviceMessageByID, false);
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();
        StreamClosedHttpResponse httpResponse = httpUtils.doGetWithParasGetStatusLine(url, header, paramsMap);

        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getContent());
        System.out.println();

        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            httpResponseResult = JSONObject.parseObject(httpResponse.getContent(), HttpResponseResult.class);
        } else if (httpResponse.getContent() != null) {
            queryDeviceMessageByIDResponse = JSONObject.parseObject(httpResponse.getContent(), QueryDeviceMessageByIDResponse.class);
        }
        httpResponseResult.setStatus_code(httpResponse.getStatusLine().getStatusCode());
        queryDeviceMessageByIDResponse.setHttpResponseResult(httpResponseResult);
        return queryDeviceMessageByIDResponse;
    }
}
