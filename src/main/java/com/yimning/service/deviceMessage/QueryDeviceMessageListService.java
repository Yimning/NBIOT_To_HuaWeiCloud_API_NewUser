package com.yimning.service.deviceMessage;


import com.yimning.entity.deviceMessage.QueryDeviceMessageList;
import com.yimning.entity.deviceMessage.QueryDeviceMessageListResponse;
import com.yimning.entity.productManagement.QueryProductList;

public interface QueryDeviceMessageListService {
    /** 
     * @Description: 查询设备消息列表
     */
    public QueryDeviceMessageListResponse queryDeviceMessageList(QueryDeviceMessageList queryDeviceMessageList) throws Exception ;

}
