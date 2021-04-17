package com.yimning.controller.deviceAccessController.dataCollectionController;

import com.yimning.entity.DeviceDataInfos;
import com.yimning.service.deviceAccess.dataCollection.QueryDevicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dataCollection")
public class QueryDevicesController {
    @Autowired
    private QueryDevicesService queryDevicesService;

    @PostMapping("/queryDevices")
    public DeviceDataInfos QueryDevices(@RequestBody DeviceDataInfos DeviceDataInfos)throws Exception {
        DeviceDataInfos deviceDataInfos = queryDevicesService.QueryDevices(DeviceDataInfos);
        return deviceDataInfos;
    }
}