package com.yimning.entity.deviceManagement;

import lombok.Data;

/**
 * @program: yimning
 * @description:
 * @author: Yimning
 * @create: 2021-04-17 21:01
 **/
@Data
public class InitialDesired {
    private Desired desired;
    private String service_id;
}
