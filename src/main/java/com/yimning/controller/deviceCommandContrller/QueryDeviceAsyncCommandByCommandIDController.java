package com.yimning.controller.deviceCommandContrller;

import com.yimning.entity.deviceCommand.QueryDeviceAsyncCommandByCommandID;
import com.yimning.entity.deviceCommand.QueryDeviceAsyncCommandByCommandIDResponse;
import com.yimning.service.deviceCommand.DeviceAsyncCommand.QueryDeviceAsyncCommandByCommandIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deviceMessage")
public class QueryDeviceAsyncCommandByCommandIDController {
    @Autowired
    private QueryDeviceAsyncCommandByCommandIDService queryDeviceAsyncCommandByCommandIDService;

    @GetMapping("/queryDeviceAsyncCommandByCommandID")
    public QueryDeviceAsyncCommandByCommandIDResponse queryDeviceAsyncCommandByCommandID(@ModelAttribute("queryDeviceAsyncCommandByCommandID") QueryDeviceAsyncCommandByCommandID queryDeviceAsyncCommandByCommandID) throws Exception {
        QueryDeviceAsyncCommandByCommandIDResponse queryDeviceAsyncCommandByCommandIDResponse = queryDeviceAsyncCommandByCommandIDService.queryDeviceAsyncCommandByCommandID(queryDeviceAsyncCommandByCommandID);
        return queryDeviceAsyncCommandByCommandIDResponse;
    }

}
