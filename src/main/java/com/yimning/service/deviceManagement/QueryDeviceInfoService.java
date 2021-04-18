package com.yimning.service.deviceManagement;

import com.yimning.entity.deviceManagement.QueryDeviceInfo;
import com.yimning.entity.deviceManagement.QueryDeviceInfoResponse;

public interface QueryDeviceInfoService {
    /** 
     * @Description: 查询设备信息
     */
    public QueryDeviceInfoResponse queryDeviceInfo(QueryDeviceInfo queryDeviceInfo) throws Exception ;

}
