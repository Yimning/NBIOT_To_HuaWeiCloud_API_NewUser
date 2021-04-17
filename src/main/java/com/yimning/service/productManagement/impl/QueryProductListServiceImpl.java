package com.yimning.service.productManagement.impl;


import com.alibaba.fastjson.JSONObject;
import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.product.QueryProductList;
import com.yimning.service.auth.Authentication;
import com.yimning.service.productManagement.QueryProductListService;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.StreamClosedHttpResponse;
import com.yimning.utils.TypeConversionUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
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
public class QueryProductListServiceImpl implements QueryProductListService {
    @Override
    public QueryProductList QueryProductList(QueryProductList queryProductList) throws Exception {
        String token = Authentication.getToken();

        String url = Constant.PRODUCT_COMMAND_URL;
        if (queryProductList.getProject_id() != null)
            url = String.format(url, queryProductList.getProject_id());

        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", "application/json");
        header.put("X-Auth-Token", token);
        Map paramsMap = TypeConversionUtils.getObjectToValMap(queryProductList, false);
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();
        StreamClosedHttpResponse httpResponse = httpUtils.doGet(url, header, paramsMap);

        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getContent());
        System.out.println();
        HttpResponseResult httpResponseResult = new HttpResponseResult();
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            httpResponseResult = JSONObject.parseObject(httpResponse.getContent(), HttpResponseResult.class);
        }else {
            queryProductList = JSONObject.parseObject(httpResponse.getContent(), QueryProductList.class);
        }
        httpResponseResult.setStatus_code(httpResponse.getStatusLine().getStatusCode());
        httpResponseResult.setReason_phrase(httpResponse.getStatusLine().getReasonPhrase());
        queryProductList.setHttpResponseResult(httpResponseResult);
        return queryProductList;
    }
}
