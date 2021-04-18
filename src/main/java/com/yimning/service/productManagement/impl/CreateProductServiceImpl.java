package com.yimning.service.productManagement.impl;

import com.alibaba.fastjson.JSONObject;
import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.product.*;
import com.yimning.service.auth.Authentication;
import com.yimning.service.productManagement.CreateProductService;
import com.yimning.service.projectManagement.QueryProjectsIDService;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CreateProductServiceImpl implements CreateProductService {
    @Autowired
    private QueryProjectsIDService queryProjectsIDService;

    @Override
    public HttpResponseResult createProduct(AddProduct addProduct) throws Exception {
        String token = Authentication.getToken();
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();
        String project_id = null;
        String url = Constant.CREATE_PRODUCT;
        if (addProduct.getProject_id() != null)
            project_id = addProduct.getProject_id();
        url = String.format(url, project_id);

        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", "application/json");
        header.put("X-Auth-Token", token);
        System.out.println(header);
        StreamClosedHttpResponse httpResponse = httpUtils.doPost(url, header, JsonUtils.jsonObj2Sting(addProduct));

        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getContent());
        HttpResponseResult httpResponseResult = new HttpResponseResult();
        if (httpResponse.getStatusLine().getStatusCode() != 201) {
            httpResponseResult = JSONObject.parseObject(httpResponse.getContent(), HttpResponseResult.class);
        }
        httpResponseResult.setStatus_code(httpResponse.getStatusLine().getStatusCode());
        httpResponseResult.setReason_phrase(httpResponse.getStatusLine().getReasonPhrase());
        return httpResponseResult;
    }
}
