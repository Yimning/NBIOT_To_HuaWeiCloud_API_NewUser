package com.yimning.service.productManagement.impl;


import com.alibaba.fastjson.JSONObject;
import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.product.QueryProduct;
import com.yimning.service.auth.Authentication;
import com.yimning.service.productManagement.QueryProductService;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.StreamClosedHttpResponse;
import com.yimning.utils.TypeConversionUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/** 
* @Description: 查询产品  project_id不能为空
* @Param:  
* @return:  
* @Author: Yimning
* @Date: 2021/4/17 
*/
@Service
public class QueryProductServiceImpl implements QueryProductService {
    @Override
    public QueryProduct QueryProduct(QueryProduct queryProduct) throws Exception {
        String token = Authentication.getToken();

        String url = Constant.QUERY_PRODUCT;
        if (queryProduct.getProject_id() != null)
            url = String.format(url, queryProduct.getProject_id(),queryProduct.getProduct_id());
        System.out.println(url);
        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", "application/json");
        header.put("X-Auth-Token", token);
        Map paramsMap = TypeConversionUtils.getObjectToValMap(queryProduct, false);
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();
        StreamClosedHttpResponse httpResponse = httpUtils.doGet(url, header, null);

        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getContent());
        System.out.println();
        HttpResponseResult httpResponseResult = new HttpResponseResult();
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            httpResponseResult = JSONObject.parseObject(httpResponse.getContent(), HttpResponseResult.class);
        }else {
            queryProduct = JSONObject.parseObject(httpResponse.getContent(), QueryProduct.class);
        }
        httpResponseResult.setStatus_code(httpResponse.getStatusLine().getStatusCode());
        httpResponseResult.setReason_phrase(httpResponse.getStatusLine().getReasonPhrase());
        queryProduct.setHttpResponseResult(httpResponseResult);
        return queryProduct;
    }
}
