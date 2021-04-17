package com.yimning.controller.productManagementController;
import com.yimning.common.lang.HttpResponseResult;
import com.yimning.entity.product.DeleteProduct;
import com.yimning.service.productManagement.DeleteProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productManagement")
public class DeleteProductController {
    @Autowired
    private DeleteProductService deleteProductService;

    @GetMapping("/deleteProduct")
    public HttpResponseResult QueryDevice(@ModelAttribute DeleteProduct deleteProduct)throws Exception {
        System.out.println(deleteProduct);
        HttpResponseResult httpResponseResult = deleteProductService.DeleteProduct(deleteProduct);
        return httpResponseResult;
    }
}