package com.yimning.service.productManagement.impl;

import com.yimning.service.apig.SignUtil;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.StreamClosedHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class QueryProductListByAKServiceImpl {

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException {
        String url = Constant.PRODUCT_COMMAND_URL;
        String project_id = "31231";
        url = String.format(url, project_id);

        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", "application/json");

        HttpRequestBase httpRequestBase = SignUtil.signRequest(url, "GET", header, null, null);

        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();
        StreamClosedHttpResponse httpResponse = (StreamClosedHttpResponse)httpUtils.execute(httpRequestBase);

        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getContent());
    }
}
