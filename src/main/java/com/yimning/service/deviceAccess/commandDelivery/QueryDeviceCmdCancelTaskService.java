package com.yimning.service.deviceAccess.commandDelivery;

import com.yimning.entity.QueryDeviceCommands;


public interface QueryDeviceCmdCancelTaskService {
    /** 
     * @Description: 查询设备命令撤销任务
     */
    public QueryDeviceCommands QueryDeviceCmdCancelTask(QueryDeviceCommands queryDeviceCommands) throws Exception ;

}

