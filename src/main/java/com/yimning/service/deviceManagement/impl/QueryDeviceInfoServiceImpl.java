package com.yimning.service.deviceManagement.impl;

import com.alibaba.fastjson.JSONObject;
import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.deviceManagement.QueryDeviceInfo;
import com.yimning.entity.deviceManagement.QueryDeviceInfoResponse;
import com.yimning.service.auth.Authentication;
import com.yimning.service.deviceManagement.QueryDeviceInfoService;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.StreamClosedHttpResponse;
import com.yimning.utils.TypeConversionUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class QueryDeviceInfoServiceImpl implements QueryDeviceInfoService {
    @Override
    public QueryDeviceInfoResponse queryDeviceInfo(QueryDeviceInfo queryDeviceInfo) throws Exception {
        String token = Authentication.getToken();

        String url = Constant.QUERY_DEVICE_LIST;
        if (queryDeviceInfo.getProject_id() != null)
            url = String.format(url, queryDeviceInfo.getProject_id());
        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", Constant.Content_Type);
        header.put("X-Auth-Token", token);

        Map paramsMap = TypeConversionUtils.getObjectToValMap(queryDeviceInfo, false);

        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();

        StreamClosedHttpResponse httpResponse = httpUtils.doGetWithParasGetStatusLine(url, header, paramsMap);
        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getContent());
        HttpResponseResult httpResponseResult = new HttpResponseResult();
        QueryDeviceInfoResponse queryDeviceInfoResponse = new QueryDeviceInfoResponse();
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            httpResponseResult = JSONObject.parseObject(httpResponse.getContent(), HttpResponseResult.class);
        }else {
            queryDeviceInfoResponse = JSONObject.parseObject(httpResponse.getContent(), QueryDeviceInfoResponse.class);
        }
        httpResponseResult.setStatus_code(httpResponse.getStatusLine().getStatusCode());
        httpResponseResult.setReason_phrase(httpResponse.getStatusLine().getReasonPhrase());
        queryDeviceInfoResponse.setHttpResponseResult(httpResponseResult);
        
        return queryDeviceInfoResponse;
    }
}
