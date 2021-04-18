package com.yimning.controller.productManagementController;
import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.productManagement.AddProduct;
import com.yimning.service.productManagement.CreateProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productManagement")
public class CreateProductController {
    @Autowired
    private CreateProductService createProductService;

    @PostMapping("/createProduct")
    public HttpResponseResult CreateProduct(@RequestBody AddProduct addProduct)throws Exception {
        HttpResponseResult httpResponseResult = createProductService.createProduct(addProduct);
        return httpResponseResult;
    }
}
