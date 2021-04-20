package com.yimning.service.DeviceProperties.impl;


import com.alibaba.fastjson.JSONObject;
import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.DeviceProperties.QueryDevicePropertiesList;
import com.yimning.entity.DeviceProperties.QueryDevicePropertiesListResponse;
import com.yimning.entity.deviceManagement.QueryDeviceListResponse;
import com.yimning.entity.deviceMessage.QueryDeviceMessageListResponse;
import com.yimning.entity.productManagement.QueryProductList;
import com.yimning.service.DeviceProperties.QueryDevicePropertiesListService;
import com.yimning.service.auth.Authentication;
import com.yimning.utils.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class QueryDevicePropertiesListServiceImpl implements QueryDevicePropertiesListService {

    @Override
    public QueryDevicePropertiesListResponse queryDevicePropertiesList(QueryDevicePropertiesList queryDevicePropertiesList) throws Exception {
        QueryDevicePropertiesListResponse queryDevicePropertiesListResponse = new QueryDevicePropertiesListResponse();
        HttpResponseResult httpResponseResult = new HttpResponseResult();

        String token = Authentication.getToken();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", Constant.Content_Type);
        headers.put("X-Auth-Token", token);

        String url = Constant.RESET_DEVICE_SECRET;
        String service_id_default = "resetSecret";
        if (queryDevicePropertiesList.getProject_id() != null && queryDevicePropertiesList.getDevice_id() != null)
            url = String.format(url, queryDevicePropertiesList.getProject_id(), queryDevicePropertiesList.getDevice_id());
        else {
            httpResponseResult.setStatus_code(403);
            httpResponseResult.setError_msg("项目ID或设备ID为空");
            queryDevicePropertiesListResponse.setHttpResponseResult(httpResponseResult);
            return queryDevicePropertiesListResponse;
        }
        if (queryDevicePropertiesList.getService_id() != null)
            url = url + "?service_id=" + queryDevicePropertiesList.getService_id();
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();
        Map paramsMap = TypeConversionUtils.getObjectToValMap(queryDevicePropertiesList, false);
        StreamClosedHttpResponse httpResponse = httpUtils.doGetWithParasGetStatusLine(url, headers, paramsMap);

        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getContent());
        System.out.println();

        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            httpResponseResult = JSONObject.parseObject(httpResponse.getContent(), HttpResponseResult.class);
        } else {
            queryDevicePropertiesListResponse = JSONObject.parseObject(httpResponse.getContent(), QueryDevicePropertiesListResponse.class);
        }
        httpResponseResult.setStatus_code(httpResponse.getStatusLine().getStatusCode());
        httpResponseResult.setReason_phrase(httpResponse.getStatusLine().getReasonPhrase());
        queryDevicePropertiesListResponse.setHttpResponseResult(httpResponseResult);
        return queryDevicePropertiesListResponse;
    }
}
