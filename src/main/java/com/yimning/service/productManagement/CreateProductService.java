package com.yimning.service.productManagement;

import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.product.*;

public interface CreateProductService {
    /** 
     * @Description: 创建产品设备
     */
    public HttpResponseResult createProduct(AddProduct addProduct) throws Exception ;

}
