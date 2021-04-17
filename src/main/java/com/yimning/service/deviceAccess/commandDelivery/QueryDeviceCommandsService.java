package com.yimning.service.deviceAccess.commandDelivery;

import java.util.Map;

import com.yimning.entity.QueryDeviceCommands;

public interface QueryDeviceCommandsService {
    /** 
     * @Description: 查询设备命令
     */
    public Map<String, Object> QueryDeviceCommands(QueryDeviceCommands queryDeviceCommands) throws Exception ;

}