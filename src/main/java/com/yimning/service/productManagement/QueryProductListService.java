package com.yimning.service.productManagement;


import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.product.AddProduct;
import com.yimning.entity.product.QueryProductList;
import com.yimning.utils.Constant;
import com.yimning.utils.HttpUtils;
import com.yimning.utils.StreamClosedHttpResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public interface QueryProductListService {
    /** 
     * @Description: 查询产品列表
     */
    public QueryProductList QueryProductList(QueryProductList queryProductList) throws Exception ;

}
