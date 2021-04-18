package com.yimning.controller.deviceManagementController;


import com.yimning.entity.deviceManagement.AddDevice;
import com.yimning.entity.deviceManagement.AddDeviceResponse;
import com.yimning.service.deviceManagement.CreateDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deviceManagement")
public class CreateDeviceController {
    @Autowired
    private CreateDeviceService createDeviceService;

    @PostMapping("/createDevice")
    public AddDeviceResponse DeleteDevice(@RequestBody AddDevice addDevice) throws Exception {
        AddDeviceResponse addDeviceResponse = createDeviceService.createDevice(addDevice);
        return addDeviceResponse;
    }

}
