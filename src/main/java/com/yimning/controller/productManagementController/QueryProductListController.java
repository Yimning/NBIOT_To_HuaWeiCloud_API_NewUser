package com.yimning.controller.productManagementController;
import com.yimning.entity.product.QueryProductList;
import com.yimning.service.productManagement.QueryProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productManagement")
public class QueryProductListController {
    @Autowired
    private QueryProductListService queryProductListService;

    @PostMapping("/queryProductList")
    public QueryProductList QueryDevice(@RequestBody QueryProductList queryProductList)throws Exception {
       queryProductList = queryProductListService.QueryProductList(queryProductList);
        return queryProductList;
    }
}