package com.yimning.entity.product;

import lombok.Data;

/**
 * @program: yimning
 * @description: 查询结果的分页信息
 * @author: Yimning
 * @create: 2021-04-17 15:52
 **/
@Data
public class Page {
    private int count;
    private String marker;
}
