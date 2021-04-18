package com.yimning.controller.deviceManagementController;


import com.yimning.entity.deviceManagement.ResetDeviceSecret;
import com.yimning.entity.deviceManagement.ResetDeviceSecretResponse;
import com.yimning.service.deviceManagement.ResetDeviceSecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deviceManagement")
public class ResetDeviceSecretController {
    @Autowired
    private ResetDeviceSecretService resetDeviceSecretService;

    @PostMapping("/resetDeviceSecret")
    public ResetDeviceSecretResponse ResetDeviceSecret(@RequestBody ResetDeviceSecret resetDeviceSecret) throws Exception {
        ResetDeviceSecretResponse resetDeviceSecretResponse = resetDeviceSecretService.resetDeviceSecret(resetDeviceSecret);
        return resetDeviceSecretResponse;
    }

}
