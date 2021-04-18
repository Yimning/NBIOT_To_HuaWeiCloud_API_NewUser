package com.yimning.service.productManagement;

import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.productManagement.DeleteProduct;

public interface DeleteProductService {
    /**
     * @Description: 删除产品
     */
    public HttpResponseResult deleteProduct(DeleteProduct deleteProduct) throws Exception;
}