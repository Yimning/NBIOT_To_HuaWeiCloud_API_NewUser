package com.yimning.service.deviceAccess.commandDelivery;

import com.yimning.entity.DeviceCommands;


public interface ModifyDeviceCommandService {
    /** 
     * @Description: 修改设备命令
     */
    public DeviceCommands ModifyDeviceCommand(DeviceCommands deviceCommands) throws Exception ;

}
