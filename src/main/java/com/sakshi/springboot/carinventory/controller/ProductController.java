package com.sakshi.springboot.carinventory.controller;

import com.sakshi.springboot.carinventory.dto.*;
import com.sakshi.springboot.carinventory.service.CategoryService;
import com.sakshi.springboot.carinventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/product")

public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(path = "/save")
    public String saveProduct(@RequestBody ProductDTOSave productDTOSave) {
        String productName = productService.addProduct(productDTOSave);
        return productName;
    }
    @GetMapping("/getAllProducts")
    public List<ProductDTO> getAllProduct() {
        List<ProductDTO> allProducts = productService.getAllProducts();
        return allProducts;
    }
    @PutMapping("/update")
    public String updateProduct(@RequestBody ProductDTOUpdate productDTOUpdate) {
        String Id = productService.updateProduct(productDTOUpdate);
        return "update";
    }
    @DeleteMapping(path = "/delete/{Id}")
    public String deleteProduct(@PathVariable(value = "Id") int Id) {
        boolean deleteProduct = productService.deleteProduct(Id);
        return "delete";

    }
}