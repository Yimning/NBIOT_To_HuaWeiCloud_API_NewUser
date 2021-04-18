package com.yimning.controller.deviceManagementController;


import com.yimning.entity.device.UpdateDeviceInfo;
import com.yimning.entity.device.UpdateDeviceInfoResponse;
import com.yimning.service.deviceManagement.UpdateDeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deviceManagement")
public class UpdateDeviceInfoController {
    @Autowired
    private UpdateDeviceInfoService updateDeviceInfoService;

    @PutMapping("/updateDeviceInfo")
    public UpdateDeviceInfoResponse UpdateDeviceInfo(@RequestBody UpdateDeviceInfo updateDeviceInfo) throws Exception {
        UpdateDeviceInfoResponse updateDeviceInfoResponse = updateDeviceInfoService.updateDeviceInfo(updateDeviceInfo);
        return updateDeviceInfoResponse;
    }

}
