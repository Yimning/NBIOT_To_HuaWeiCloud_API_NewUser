package com.yimning.controller.DevicePropertiesController;

import com.yimning.entity.DeviceProperties.QueryDevicePropertiesList;
import com.yimning.entity.DeviceProperties.QueryDevicePropertiesListResponse;
import com.yimning.service.DeviceProperties.QueryDevicePropertiesListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deviceProperties")
public class QueryDevicePropertiesListController {
    @Autowired
    private QueryDevicePropertiesListService queryDevicePropertiesListService;

    @GetMapping("/queryDevicePropertiesList")
    public QueryDevicePropertiesListResponse queryDevicePropertiesList(@ModelAttribute("queryDevicePropertiesList") QueryDevicePropertiesList queryDevicePropertiesList) throws Exception {
        QueryDevicePropertiesListResponse queryDevicePropertiesListResponse = queryDevicePropertiesListService.queryDevicePropertiesList(queryDevicePropertiesList);
        return queryDevicePropertiesListResponse;
    }

}
