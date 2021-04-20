package com.yimning.service.DeviceProperties;


import com.yimning.entity.DeviceProperties.QueryDevicePropertiesList;
import com.yimning.entity.DeviceProperties.QueryDevicePropertiesListResponse;
import com.yimning.entity.DeviceProperties.UpdateDeviceProperties;
import com.yimning.entity.DeviceProperties.UpdateDevicePropertiesResponse;

public interface UpdateDevicePropertiesService {
    /** 
     * @Description: 查询设备属性
     */
    public UpdateDevicePropertiesResponse updateDeviceProperties(UpdateDeviceProperties updateDeviceProperties) throws Exception ;

}
