package com.yimning.entity.productManagement;

import lombok.Data;

/**
 * @program: yimning
 * @description: 删除产品
 * @author: Yimning
 * @create: 2021-04-17 17:06
 **/
@Data
public class DeleteProduct {
    private String project_id;
    private String product_id;

    private String app_id;
}
