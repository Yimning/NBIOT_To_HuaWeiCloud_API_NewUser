package com.yimning.service.deviceCommand.DeviceAsyncCommand;


import com.yimning.entity.deviceCommand.CreateDeviceAsyncCommand;
import com.yimning.entity.deviceCommand.CreateDeviceAsyncCommandResponse;
import com.yimning.entity.deviceCommand.QueryDeviceAsyncCommandByCommandID;
import com.yimning.entity.deviceCommand.QueryDeviceAsyncCommandByCommandIDResponse;

public interface QueryDeviceAsyncCommandByCommandIDService {
    /** 
     * @Description: 通过命令ID查询设备异步命令
     */
    public QueryDeviceAsyncCommandByCommandIDResponse queryDeviceAsyncCommandByCommandID(QueryDeviceAsyncCommandByCommandID queryDeviceAsyncCommandByCommandID) throws Exception ;

}
