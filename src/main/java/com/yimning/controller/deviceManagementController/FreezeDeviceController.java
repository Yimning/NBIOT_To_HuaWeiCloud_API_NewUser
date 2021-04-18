package com.yimning.controller.deviceManagementController;


import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.device.FreezeDevice;
import com.yimning.service.deviceManagement.FreezeDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deviceManagement")
public class FreezeDeviceController {
    @Autowired
    private FreezeDeviceService freezeDeviceService;

    @PostMapping("/freezeDevice")
    public HttpResponseResult DeleteDevice(@RequestBody FreezeDevice freezeDevice) throws Exception {
        HttpResponseResult httpResponseResult = freezeDeviceService.freezeDevice(freezeDevice);
        return httpResponseResult;
    }

}
