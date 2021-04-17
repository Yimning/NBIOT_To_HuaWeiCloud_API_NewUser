package com.yimning.controller.productManagementController;
import com.yimning.entity.product.ModifyProduct;
import com.yimning.service.productManagement.ModifyProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productManagement")
public class ModifyProductController {
    @Autowired
    private ModifyProductService modifyProductService;

    @PostMapping("/modifyProduct")
    public ModifyProduct QueryDevice(@RequestBody ModifyProduct modifyProduct)throws Exception {
        modifyProduct = modifyProductService.ModifyProduct(modifyProduct);
        return modifyProduct;
    }
}