package com.yimning.service.productManagement;

import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.product.DeleteProduct;

public interface DeleteProductService {
    /**
     * @Description: 删除产品
     */
    public HttpResponseResult DeleteProduct(DeleteProduct deleteProduct) throws Exception;
}