package com.yimning.controller.deviceAccessController.dataCollectionController;

import com.yimning.entity.DeviceHistoryData;
import com.yimning.service.deviceAccess.dataCollection.QueryDeviceHistoryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dataCollection")
public class QueryDeviceHistoryDataController {
    @Autowired
    private QueryDeviceHistoryDataService queryDeviceHistoryDataService;

    @PostMapping("/queryDeviceHistoryData")
    public DeviceHistoryData QueryDevice(@RequestBody DeviceHistoryData  deviceHistoryData)throws Exception {
        deviceHistoryData = queryDeviceHistoryDataService.QueryDeviceHistoryData(deviceHistoryData);
        return deviceHistoryData;
    }
}