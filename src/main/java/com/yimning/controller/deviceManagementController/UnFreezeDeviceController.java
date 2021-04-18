package com.yimning.controller.deviceManagementController;


import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.deviceManagement.UnFreezeDevice;
import com.yimning.service.deviceManagement.UnFreezeDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deviceManagement")
public class UnFreezeDeviceController {
    @Autowired
    private UnFreezeDeviceService unFreezeDeviceService;

    @PostMapping("/unFreezeDevice")
    public HttpResponseResult DeleteDevice(@RequestBody UnFreezeDevice unFreezeDevice) throws Exception {
        HttpResponseResult httpResponseResult = unFreezeDeviceService.unFreezeDevice(unFreezeDevice);
        return httpResponseResult;
    }

}
