package com.yimning.controller.deviceCommandContrller;


import com.yimning.entity.deviceCommand.CreateDeviceAsyncCommand;
import com.yimning.entity.deviceCommand.CreateDeviceAsyncCommandResponse;
import com.yimning.service.deviceCommand.DeviceAsyncCommand.CreateDeviceAsyncCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
* @Description: 设备的产品模型中定义了物联网平台可向设备下发的命令，应用服务器可调用此接口向指定设备下发异步命令，以实现对设备的控制。
 * 平台负责将命令发送给设备，并将设备执行命令结果异步通知应用服务器。
 * 命令执行结果支持灵活的数据流转，应用服务器通过调用物联网平台的创建规则触发条件（Resource:device.command.status，Event:update）、
 * 创建规则动作并激活规则后，当命令状态变更时，物联网平台会根据规则将结果发送到规则指定的服务器，如用户自定义的HTTP服务器，AMQP服务器，
 * 以及华为云的其他储存服务器等, 详情参考设备命令状态变更通知。
 * 注意：此接口适用于NB设备异步命令下发，暂不支持其他协议类型设备命令下发。 
* @Param:  
* @return:  
* @Author: Yimning
* @Date: 2021/4/20 
*/

@RestController
@RequestMapping("/deviceCommand")
public class CreateDeviceAsyncCommandController {
    @Autowired
    private CreateDeviceAsyncCommandService createDeviceAsyncCommandService;

    @PostMapping("/createDeviceAsyncCommand")
    public CreateDeviceAsyncCommandResponse DeleteDevice(@RequestBody CreateDeviceAsyncCommand createDeviceAsyncCommand) throws Exception {
        CreateDeviceAsyncCommandResponse createDeviceAsyncCommandResponse = createDeviceAsyncCommandService.createDeviceAsyncCommand(createDeviceAsyncCommand);
        return createDeviceAsyncCommandResponse;
    }

}
