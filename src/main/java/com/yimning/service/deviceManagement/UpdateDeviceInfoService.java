package com.yimning.service.deviceManagement;

import com.yimning.entity.device.UpdateDeviceInfo;
import com.yimning.entity.device.UpdateDeviceInfoResponse;

public interface UpdateDeviceInfoService {
    /** 
     * @Description: 更新设备信息
     */
    public UpdateDeviceInfoResponse updateDeviceInfo(UpdateDeviceInfo updateDeviceInfo) throws Exception ;

}
