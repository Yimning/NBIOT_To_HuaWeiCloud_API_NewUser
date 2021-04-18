package com.yimning.service.deviceManagement;

import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.StreamClosedHttpResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class QueryDeviceListService {

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, IOException, URISyntaxException {
        String token = null;

        String project_id = "23123";
        String url = Constant.DEVICE_COMMAND_URL;
        url = String.format(url, project_id);
        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", "application/json");
        header.put("X-Auth-Token", token);

        Map<String, String> params = new HashMap<String, String>();
        //params.put("gateway_id", "5e09f371334dd4f337056da0_gaoshang_001");
        params.put("node_id", "gaoshang_001");

        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();

        StreamClosedHttpResponse httpResponse = httpUtils.doGet(url, header, params);
        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getContent());
    }
}
