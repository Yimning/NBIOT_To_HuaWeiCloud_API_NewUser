package com.yimning.controller.DevicePropertiesController;


import com.yimning.entity.DeviceProperties.UpdateDeviceProperties;
import com.yimning.entity.DeviceProperties.UpdateDevicePropertiesResponse;
import com.yimning.service.DeviceProperties.UpdateDevicePropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deviceProperties")
public class UpdateDevicePropertiesController {
    @Autowired
    private UpdateDevicePropertiesService updateDevicePropertiesService;

    @PutMapping("/updateDeviceProperties")
    public UpdateDevicePropertiesResponse UpdateDeviceProperties(@RequestBody UpdateDeviceProperties UpdateDeviceProperties) throws Exception {
        UpdateDevicePropertiesResponse UpdateDevicePropertiesResponse = updateDevicePropertiesService.updateDeviceProperties(UpdateDeviceProperties);
        return UpdateDevicePropertiesResponse;
    }

}
