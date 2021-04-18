package com.yimning.controller.deviceManagementController;

import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.deviceManagement.DeleteDevice;
import com.yimning.service.deviceManagement.DeleteDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deviceManagement")
public class DeleteDeviceController {
    @Autowired
    private DeleteDeviceService deleteDeviceService;

    @DeleteMapping("/deleteDevice")
    public HttpResponseResult QueryDevice(@RequestBody DeleteDevice deleteDevice)throws Exception {
        System.out.println(deleteDevice);
        HttpResponseResult httpResponseResult = deleteDeviceService.deleteDevice(deleteDevice);
        return httpResponseResult;
    }
}