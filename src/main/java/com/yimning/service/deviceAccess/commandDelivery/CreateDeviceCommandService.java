package com.yimning.service.deviceAccess.commandDelivery;

import com.yimning.entity.DeviceCommands;


public interface CreateDeviceCommandService {
    /** 
     * @Description: 创建设备命令
     */
    public DeviceCommands CreateDeviceCommand(DeviceCommands deviceCommands) throws Exception ;

}
