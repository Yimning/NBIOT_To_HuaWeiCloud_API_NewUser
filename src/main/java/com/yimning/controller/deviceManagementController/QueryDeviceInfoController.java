package com.yimning.controller.deviceManagementController;


import com.yimning.entity.device.QueryDeviceInfo;
import com.yimning.entity.device.QueryDeviceInfoResponse;
import com.yimning.service.deviceManagement.QueryDeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deviceManagement")
public class QueryDeviceInfoController {
    @Autowired
    private QueryDeviceInfoService queryDeviceInfoService;

    @GetMapping("/queryDeviceInfo")
    public QueryDeviceInfoResponse QueryDeviceInfo(@ModelAttribute("queryDeviceInfo") QueryDeviceInfo queryDeviceInfo) throws Exception {
        QueryDeviceInfoResponse queryDeviceInfoResponse = queryDeviceInfoService.queryDeviceInfo(queryDeviceInfo);
        return queryDeviceInfoResponse;
    }

}
