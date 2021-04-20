package com.yimning.controller.deviceCommandContrller;


import com.yimning.entity.deviceCommand.CreateDeviceSyncCommand;
import com.yimning.entity.deviceCommand.CreateDeviceSyncCommandResponse;
import com.yimning.service.deviceCommand.DeviceSyncCommand.CreateDeviceSyncCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deviceCommand")
public class CreateDeviceSyncCommandController {
    @Autowired
    private CreateDeviceSyncCommandService createDeviceSyncCommandService;

    @PostMapping("/createDeviceSyncCommand")
    public CreateDeviceSyncCommandResponse DeleteDevice(@RequestBody CreateDeviceSyncCommand createDeviceSyncCommand) throws Exception {
        CreateDeviceSyncCommandResponse createDeviceSyncCommandResponse = createDeviceSyncCommandService.createDeviceSyncCommand(createDeviceSyncCommand);
        return createDeviceSyncCommandResponse;
    }

}
