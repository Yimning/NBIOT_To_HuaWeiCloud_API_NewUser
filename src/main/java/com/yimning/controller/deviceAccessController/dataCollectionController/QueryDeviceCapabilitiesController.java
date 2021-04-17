package com.yimning.controller.deviceAccessController.dataCollectionController;

import com.yimning.entity.QueryDeviceCapabilities;
import com.yimning.service.deviceAccess.dataCollection.QueryDeviceCapabilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dataCollection")
public class QueryDeviceCapabilitiesController {
    @Autowired
    private QueryDeviceCapabilitiesService queryDeviceCapabilitiesService;

    @PostMapping("/queryDeviceCapabilities")
    public QueryDeviceCapabilities QueryDevice(@RequestBody QueryDeviceCapabilities queryDeviceCapabilities)throws Exception {
         queryDeviceCapabilities = queryDeviceCapabilitiesService.QueryDeviceCapabilities(queryDeviceCapabilities);
        return queryDeviceCapabilities;
    }
}