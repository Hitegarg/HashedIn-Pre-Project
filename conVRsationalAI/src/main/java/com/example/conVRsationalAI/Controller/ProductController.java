package com.example.conVRsationalAI.Controller;

import com.example.conVRsationalAI.Entity.Product_details;
import com.example.conVRsationalAI.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    @PostMapping("/product")
    public Product_details insertProduct(@RequestBody Product_details product_details) {
        System.out.println(product_details.toString());
        return productService.insertProduct(product_details);
    }

    @GetMapping("/product")
    public List<Product_details> getAll() {
        return productService.getAll();
    }
    @GetMapping("/product/{category}")
    public Product_details getProduct(@PathVariable(value = "category") String category){
        return productService.getProduct(category);
    }

//    @GetMapping("/colour/{colour}")
//    public void getProductByColour(@PathVariable(value = "colour") String colour){
//        productService.searchOnColour(colour);
//    }

}
