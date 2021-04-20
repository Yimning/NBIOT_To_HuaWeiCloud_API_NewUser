package com.yimning.service.deviceCommand.DeviceSyncCommand;


import com.yimning.entity.deviceCommand.CreateDeviceSyncCommand;
import com.yimning.entity.deviceCommand.CreateDeviceSyncCommandResponse;

public interface CreateDeviceSyncCommandService {
    /** 
     * @Description: 设备同步命令
     */
    public CreateDeviceSyncCommandResponse createDeviceSyncCommand(CreateDeviceSyncCommand createDeviceSyncCommand) throws Exception ;

}
