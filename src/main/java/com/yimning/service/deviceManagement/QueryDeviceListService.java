package com.yimning.service.deviceManagement;

import com.yimning.entity.deviceManagement.QueryDeviceList;
import com.yimning.entity.deviceManagement.QueryDeviceListResponse;

public interface QueryDeviceListService {
    /** 
     * @Description: 查询设备列表
     */
    public QueryDeviceListResponse queryDeviceList(QueryDeviceList queryDeviceList) throws Exception ;

}
