package com.yimning.service.deviceManagement.impl;

import com.alibaba.fastjson.JSONObject;
import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.deviceManagement.QueryDeviceList;
import com.yimning.entity.deviceManagement.QueryDeviceListResponse;
import com.yimning.service.auth.Authentication;
import com.yimning.service.deviceManagement.QueryDeviceListService;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.StreamClosedHttpResponse;
import com.yimning.utils.TypeConversionUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class QueryDeviceListServiceImpl implements QueryDeviceListService {
    @Override
    public QueryDeviceListResponse queryDeviceList(QueryDeviceList queryDeviceList) throws Exception {
        String token = Authentication.getToken();

        String url = Constant.QUERY_DEVICE_LIST;
        if (queryDeviceList.getProject_id() != null)
            url = String.format(url, queryDeviceList.getProject_id());
        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", Constant.Content_Type);
        header.put("X-Auth-Token", token);

//        Map<String, String> params = new HashMap<String, String>();
//        //params.put("gateway_id", "5e09f371334dd4f337056da0_gaoshang_001");
//        params.put("node_id", "gaoshang_001");
        Map paramsMap = TypeConversionUtils.getObjectToValMap(queryDeviceList, false);

        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();

        StreamClosedHttpResponse httpResponse = httpUtils.doGetWithParasGetStatusLine(url, header, paramsMap);
        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getContent());
        HttpResponseResult httpResponseResult = new HttpResponseResult();
        QueryDeviceListResponse queryDeviceListResponse = new QueryDeviceListResponse();
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            httpResponseResult = JSONObject.parseObject(httpResponse.getContent(), HttpResponseResult.class);
        }else {
            queryDeviceListResponse = JSONObject.parseObject(httpResponse.getContent(), QueryDeviceListResponse.class);
        }
        httpResponseResult.setStatus_code(httpResponse.getStatusLine().getStatusCode());
        httpResponseResult.setReason_phrase(httpResponse.getStatusLine().getReasonPhrase());
        queryDeviceListResponse.setHttpResponseResult(httpResponseResult);
        
        return queryDeviceListResponse;
    }
}
