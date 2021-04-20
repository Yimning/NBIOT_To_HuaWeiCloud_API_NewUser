package com.yimning.service.deviceCommand.DeviceAsyncCommand;


import com.yimning.entity.deviceCommand.CreateDeviceAsyncCommand;
import com.yimning.entity.deviceCommand.CreateDeviceAsyncCommandResponse;

public interface QueryDeviceAsyncCommandByCommandIDService {
    /** 
     * @Description: 通过命令ID查询设备异步命令
     */
    public CreateDeviceAsyncCommandResponse createDeviceAsyncCommand(CreateDeviceAsyncCommand createDeviceAsyncCommand) throws Exception ;

}
