package com.yimning.service.deviceAccess.commandDelivery;

import com.yimning.entity.DeviceCommands;


public interface CreateDeviceCmdCancelTaskService {
    /** 
     * @Description: 创建设备命令撤销任务
     */
    public DeviceCommands CreateDeviceCmdCancelTask(DeviceCommands deviceCommands) throws Exception ;

}
