package com.yimning.service.productManagement.impl;


import com.alibaba.fastjson.JSONObject;
import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.product.ModifyProduct;
import com.yimning.service.auth.Authentication;
import com.yimning.service.productManagement.ModifyProductService;
import com.yimning.utils.*;
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
public class ModifyProductServiceImpl implements ModifyProductService {
    @Override
    public ModifyProduct ModifyProduct(ModifyProduct modifyProduct) throws Exception {
        String token = Authentication.getToken();

        String url = Constant.MODIFY_PRODUCT;
        if (modifyProduct.getProject_id() != null)
            url = String.format(url, modifyProduct.getProject_id(),modifyProduct.getProduct_id());
        System.out.println(url);
        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", "application/json");
        header.put("X-Auth-Token", token);
        //Map paramsMap = TypeConversionUtils.getObjectToValMap(modifyProduct, false);
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();
        String jsonRequest = JsonUtils.jsonObj2Sting(modifyProduct);
        StreamClosedHttpResponse httpResponse = httpUtils.doPutJsonGetStatusLine(url, header, jsonRequest);

        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getContent());
        System.out.println();
        HttpResponseResult httpResponseResult = new HttpResponseResult();
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            httpResponseResult = JSONObject.parseObject(httpResponse.getContent(), HttpResponseResult.class);
        }else {
            modifyProduct = JSONObject.parseObject(httpResponse.getContent(), ModifyProduct.class);
        }
        httpResponseResult.setStatus_code(httpResponse.getStatusLine().getStatusCode());
        httpResponseResult.setReason_phrase(httpResponse.getStatusLine().getReasonPhrase());
        modifyProduct.setHttpResponseResult(httpResponseResult);
        return modifyProduct;
    }
}
