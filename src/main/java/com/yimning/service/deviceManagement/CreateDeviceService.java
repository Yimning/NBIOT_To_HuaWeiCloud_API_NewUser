package com.yimning.service.deviceManagement;

import com.yimning.entity.device.AddDevice;
import com.yimning.entity.device.AddDeviceResponse;
import com.yimning.entity.device.AuthInfo;
import com.yimning.entity.project.ProjectsID;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.JsonUtils;
import com.yimning.utils.StreamClosedHttpResponse;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public interface CreateDeviceService {
    /** 
     * @Description: 创建设备
     */
    public AddDeviceResponse CreateDevice(AddDevice addDevice) throws Exception ;

}
