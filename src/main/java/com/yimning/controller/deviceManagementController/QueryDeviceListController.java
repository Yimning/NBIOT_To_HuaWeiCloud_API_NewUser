package com.yimning.controller.deviceManagementController;


import com.yimning.entity.device.QueryDeviceList;
import com.yimning.entity.device.QueryDeviceListResponse;
import com.yimning.entity.device.QueryDeviceList;
import com.yimning.service.deviceManagement.QueryDeviceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deviceManagement")
public class QueryDeviceListController {
    @Autowired
    private QueryDeviceListService queryDeviceListService;

    @GetMapping("/queryDeviceList")
    public QueryDeviceListResponse DeleteDevice(@ModelAttribute QueryDeviceList queryDeviceList) throws Exception {
        QueryDeviceListResponse queryDeviceListResponse = queryDeviceListService.QueryDeviceList(queryDeviceList);
        return queryDeviceListResponse;
    }

}
