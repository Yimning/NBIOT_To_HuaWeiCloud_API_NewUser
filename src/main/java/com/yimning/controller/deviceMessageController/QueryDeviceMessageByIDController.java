package com.yimning.controller.deviceMessageController;


import com.yimning.entity.deviceMessage.QueryDeviceMessageByID;
import com.yimning.entity.deviceMessage.QueryDeviceMessageByIDResponse;
import com.yimning.service.deviceMessage.QueryDeviceMessageByIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deviceMessage")
public class QueryDeviceMessageByIDController {
    @Autowired
    private QueryDeviceMessageByIDService queryDeviceMessageByIDService;

    @GetMapping("/queryDeviceMessageByID")
    public QueryDeviceMessageByIDResponse QueryDeviceMessageByID(@ModelAttribute("QueryDeviceMessageByID") QueryDeviceMessageByID queryDeviceMessageByID) throws Exception {
        QueryDeviceMessageByIDResponse queryDeviceMessageByIDResponse = queryDeviceMessageByIDService.queryDeviceMessageByID(queryDeviceMessageByID);
        return queryDeviceMessageByIDResponse;
    }

}
