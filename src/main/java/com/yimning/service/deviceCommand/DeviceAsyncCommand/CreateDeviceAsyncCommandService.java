package com.yimning.service.deviceCommand.DeviceAsyncCommand;


import com.yimning.entity.deviceCommand.CreateDeviceAsyncCommand;
import com.yimning.entity.deviceCommand.CreateDeviceAsyncCommandResponse;

public interface CreateDeviceAsyncCommandService {
    /** 
     * @Description: 设备异步命令
     */
    public CreateDeviceAsyncCommandResponse deviceAsyncCommand(CreateDeviceAsyncCommand createDeviceAsyncCommand) throws Exception ;

}
