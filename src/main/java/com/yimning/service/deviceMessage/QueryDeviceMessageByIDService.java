package com.yimning.service.deviceMessage;


import com.yimning.entity.deviceMessage.QueryDeviceMessageByID;
import com.yimning.entity.deviceMessage.QueryDeviceMessageByIDResponse;

public interface QueryDeviceMessageByIDService {
    /** 
     * @Description: 查询某个设备消息
     */
    public QueryDeviceMessageByIDResponse queryDeviceMessageByID(QueryDeviceMessageByID queryDeviceMessageByID) throws Exception ;

}
