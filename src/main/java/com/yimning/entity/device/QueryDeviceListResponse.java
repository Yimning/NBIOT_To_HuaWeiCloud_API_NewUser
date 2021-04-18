package com.yimning.entity.device;

import com.yimning.common.lang.HttpResponseResult;
import lombok.Data;

import java.util.List;

/**
 * @program: yimning
 * @description: 查询设备列表结果
 * @author: Yimning
 * @create: 2021-04-18 14:56
 **/
@Data
public class QueryDeviceListResponse {
    private List<QueryDeviceSimplify> devices;
    private Page page;
    private HttpResponseResult httpResponseResult;
}
