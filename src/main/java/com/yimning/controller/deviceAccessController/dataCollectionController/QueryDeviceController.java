package com.yimning.controller.deviceAccessController.dataCollectionController;

import com.yimning.entity.DeviceDataInfo;
import com.yimning.service.deviceAccess.dataCollection.QueryDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dataCollection")
public class QueryDeviceController {
    @Autowired
    private QueryDeviceService queryDeviceService;

    @GetMapping("/queryDevice")
    public DeviceDataInfo QueryDevice(@RequestParam(name = "deviceId", required = true) String deviceId)throws Exception {
        DeviceDataInfo deviceDataInfo = queryDeviceService.QueryDevice(deviceId);
        return deviceDataInfo;
    }
}