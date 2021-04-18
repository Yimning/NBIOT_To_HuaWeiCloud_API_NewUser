package com.yimning.controller.productManagementController;
import com.yimning.entity.product.QueryProductList;
import com.yimning.service.productManagement.QueryProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productManagement")
public class QueryProductListController {
    @Autowired
    private QueryProductListService queryProductListService;

    @GetMapping("/queryProductList")
    public QueryProductList QueryDevice(@ModelAttribute QueryProductList queryProductList)throws Exception {
       queryProductList = queryProductListService.QueryProductList(queryProductList);
        return queryProductList;
    }
}