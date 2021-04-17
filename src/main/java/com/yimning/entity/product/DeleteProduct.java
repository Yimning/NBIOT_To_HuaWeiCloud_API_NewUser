package com.yimning.entity.product;

import com.yimning.common.lang.HttpResponseResult;
import lombok.Data;

import java.util.List;

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
