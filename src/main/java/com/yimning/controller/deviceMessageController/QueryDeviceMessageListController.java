package com.yimning.controller.deviceMessageController;


import com.yimning.entity.deviceMessage.QueryDeviceMessageList;
import com.yimning.entity.deviceMessage.QueryDeviceMessageListResponse;
import com.yimning.service.deviceMessage.QueryDeviceMessageListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deviceMessage")
public class QueryDeviceMessageListController {
    @Autowired
    private QueryDeviceMessageListService queryDeviceMessageListService;

    @GetMapping("/queryDeviceMessageList")
    public QueryDeviceMessageListResponse QueryDeviceMessageList(@ModelAttribute("queryDeviceMessageList") QueryDeviceMessageList queryDeviceMessageList) throws Exception {
        System.out.println(queryDeviceMessageList);
        QueryDeviceMessageListResponse queryDeviceMessageListResponse = queryDeviceMessageListService.queryDeviceMessageList(queryDeviceMessageList);
        return queryDeviceMessageListResponse;
    }

}
