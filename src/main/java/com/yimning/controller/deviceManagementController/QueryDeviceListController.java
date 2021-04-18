package com.yimning.controller.deviceManagementController;


import com.yimning.entity.deviceManagement.QueryDeviceList;
import com.yimning.entity.deviceManagement.QueryDeviceListResponse;
import com.yimning.service.deviceManagement.QueryDeviceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deviceManagement")
public class QueryDeviceListController {
    @Autowired
    private QueryDeviceListService queryDeviceListService;

    @GetMapping("/queryDeviceList")
    public QueryDeviceListResponse QueryDeviceList(@ModelAttribute("queryDeviceList") QueryDeviceList queryDeviceList) throws Exception {
        QueryDeviceListResponse queryDeviceListResponse = queryDeviceListService.queryDeviceList(queryDeviceList);
        return queryDeviceListResponse;
    }

}
