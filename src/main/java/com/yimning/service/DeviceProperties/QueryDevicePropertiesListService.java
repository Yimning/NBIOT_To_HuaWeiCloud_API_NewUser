package com.yimning.service.DeviceProperties;


import com.yimning.entity.DeviceProperties.QueryDevicePropertiesList;
import com.yimning.entity.DeviceProperties.QueryDevicePropertiesListResponse;
import com.yimning.entity.productManagement.QueryProductList;

public interface QueryDevicePropertiesListService {
    /** 
     * @Description: 查询设备属性
     */
    public QueryDevicePropertiesListResponse queryDevicePropertiesList(QueryDevicePropertiesList queryDevicePropertiesList) throws Exception ;

}
