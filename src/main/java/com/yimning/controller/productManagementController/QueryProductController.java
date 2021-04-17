package com.yimning.controller.productManagementController;
import com.yimning.entity.product.QueryProduct;
import com.yimning.service.productManagement.QueryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productManagement")
public class QueryProductController {
    @Autowired
    private QueryProductService queryProductService;

    @PostMapping("/queryProduct")
    public QueryProduct QueryDevice(@RequestBody QueryProduct queryProduct)throws Exception {
        queryProduct = queryProductService.QueryProduct(queryProduct);
        return queryProduct;
    }
}