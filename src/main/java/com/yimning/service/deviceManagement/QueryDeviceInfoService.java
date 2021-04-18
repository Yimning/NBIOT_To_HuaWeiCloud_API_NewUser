package com.yimning.service.deviceManagement;

import com.yimning.entity.device.QueryDeviceInfo;
import com.yimning.entity.device.QueryDeviceInfoResponse;

public interface QueryDeviceInfoService {
    /** 
     * @Description: 查询设备信息
     */
    public QueryDeviceInfoResponse queryDeviceInfo(QueryDeviceInfo queryDeviceInfo) throws Exception ;

}
