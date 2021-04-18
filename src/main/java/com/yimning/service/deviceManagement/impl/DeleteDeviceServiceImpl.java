package com.yimning.service.deviceManagement.impl;

import com.alibaba.fastjson.JSONObject;
import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.deviceManagement.DeleteDevice;
import com.yimning.service.auth.Authentication;
import com.yimning.service.deviceManagement.DeleteDeviceService;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.StreamClosedHttpResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 删除设备 project_id不能为空
 * @Param:  
 * @return:  
 * @Author: Yimning
 * @Date: 2021/4/17 
 */
@Service
public class DeleteDeviceServiceImpl implements DeleteDeviceService {
    @Override
    public HttpResponseResult deleteDevice(DeleteDevice deleteDevice) throws Exception {
        String token = Authentication.getToken();

        String url = Constant.DELETE_DEVICE;
        if (deleteDevice.getProject_id() != null && deleteDevice.getDevice_id() != null)
            url = String.format(url, deleteDevice.getProject_id(), deleteDevice.getDevice_id());
        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", Constant.Content_Type);
        header.put("X-Auth-Token", token);
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.initClient();

        StreamClosedHttpResponse httpResponse = httpUtils.doDeleteWithParasGetStatusLine(url, header, null);

        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getContent());
        HttpResponseResult httpResponseResult = new HttpResponseResult();
        if (httpResponse.getContent() != null)
            httpResponseResult = JSONObject.parseObject(httpResponse.getContent(), HttpResponseResult.class);
        else {
            httpResponseResult.setReason_phrase("No Content");
        }
        httpResponseResult.setStatus_code(httpResponse.getStatusLine().getStatusCode());

        return httpResponseResult;
    }
}
