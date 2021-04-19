package com.yimning.service.deviceMessage.impl;


import com.alibaba.fastjson.JSONObject;
import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.deviceMessage.QueryDeviceMessageList;
import com.yimning.entity.deviceMessage.QueryDeviceMessageListResponse;
import com.yimning.entity.productManagement.QueryProductList;
import com.yimning.service.auth.Authentication;
import com.yimning.service.deviceMessage.QueryDeviceMessageListService;
import com.yimning.service.productManagement.QueryProductListService;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.StreamClosedHttpResponse;
import com.yimning.utils.TypeConversionUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/** 
* @Description: 查询产品的列表  project_id不能为空
* @Param:  
* @return:  
* @Author: Yimning
* @Date: 2021/4/17 
*/
@Service
public class QueryDeviceMessageListServiceImpl implements QueryDeviceMessageListService {
    @Override
    public QueryDeviceMessageListResponse queryDeviceMessageList(QueryDeviceMessageList queryDeviceMessageList) throws Exception {
        QueryDeviceMessageListResponse queryDeviceMessageListResponse = new QueryDeviceMessageListResponse();
        HttpResponseResult httpResponseResult = new HttpResponseResult();

        String token = Authentication.getToken();
        String url = Constant.QUERY_DEVICE_MESSAGE_LIST;
        if (queryDeviceMessageList.getProject_id() != null && queryDeviceMessageList.getDevice_id()!=null)
            url = String.format(url, queryDeviceMessageList.getProject_id(),queryDeviceMessageList.getDevice_id());

        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", "application/json");
        header.put("X-Auth-Token", token);
        Map paramsMap = TypeConversionUtils.getObjectToValMap(queryDeviceMessageList, false);
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();
        StreamClosedHttpResponse httpResponse = httpUtils.doGetWithParasGetStatusLine(url, header, paramsMap);

        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getContent());
        System.out.println();

        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            httpResponseResult = JSONObject.parseObject(httpResponse.getContent(), HttpResponseResult.class);
        }else {
            queryDeviceMessageListResponse = JSONObject.parseObject(httpResponse.getContent(), QueryDeviceMessageListResponse.class);
        }
        httpResponseResult.setStatus_code(httpResponse.getStatusLine().getStatusCode());
        httpResponseResult.setReason_phrase(httpResponse.getStatusLine().getReasonPhrase());
        queryDeviceMessageListResponse.setHttpResponseResult(httpResponseResult);
        return queryDeviceMessageListResponse;
    }
}
