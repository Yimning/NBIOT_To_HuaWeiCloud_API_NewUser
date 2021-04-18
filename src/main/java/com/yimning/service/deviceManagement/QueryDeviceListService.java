package com.yimning.service.deviceManagement;

import com.yimning.entity.device.AddDevice;
import com.yimning.entity.device.AddDeviceResponse;
import com.yimning.entity.device.QueryDeviceList;
import com.yimning.entity.device.QueryDeviceListResponse;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.StreamClosedHttpResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public interface QueryDeviceListService {
    /** 
     * @Description: 查询设备列表
     */
    public QueryDeviceListResponse queryDeviceList(QueryDeviceList queryDeviceList) throws Exception ;

}
