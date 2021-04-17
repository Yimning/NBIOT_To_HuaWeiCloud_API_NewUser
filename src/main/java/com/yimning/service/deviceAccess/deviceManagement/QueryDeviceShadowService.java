package com.yimning.service.deviceAccess.deviceManagement;

import com.yimning.entity.QueryDeviceShadow;

public interface QueryDeviceShadowService {
    /** 
     * @Description: 查询设备影子激活状态
     */
    public QueryDeviceShadow QueryDeviceShadow(String deviceId) throws Exception ;

}
