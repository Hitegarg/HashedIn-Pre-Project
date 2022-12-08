package com.example.conVRsationalAI.Controller;

import com.example.conVRsationalAI.Entity.Colour;
import com.example.conVRsationalAI.Entity.Product_details;
import com.example.conVRsationalAI.Entity.UserCredentials;
import com.example.conVRsationalAI.Services.ColourService;
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

    @PutMapping("/product/{productid}")
    public Product_details updateProduct(@RequestBody Product_details productdetails , @PathVariable(value = "productid") int productid){
        return productService.updateProductdetails(productid,productdetails);
    }
//    @GetMapping("/product/{colourname}")
//    public Product_details findByColour(@PathVariable(value = "colourname") String colourname){
//
//        return productService.findByColour(colourname);
//    }
@GetMapping("/get_by_colourid/{colour}")
public List<Product_details> getProductsByColorid(@PathVariable(name = "colour") int colourid){
//    System.out.println(colourid);
    return productService.getProductsByColourid(colourid);
}
    @GetMapping("/get_by_colourname/{colourname}")
    public List<Product_details> getProductsByColorname(@PathVariable(name = "colourname") String colourname){
//    System.out.println(colourid);
        return productService.getProductsByColourname(colourname);
    }
    @GetMapping("/get_by_sizeid/{size}")
    public List<Product_details> getProductsBySizeid(@PathVariable(name = "size") int sizeid){
//    System.out.println(colourid);
        return productService.getProductsBySizeid(sizeid);
    }
    @GetMapping("/get_by_sizename/{sizename}")
    public List<Product_details> getProductsBySizename(@PathVariable(name = "sizename") String sizename){
//    System.out.println(colourid);
        return productService.getProductsBySizename(sizename);
    }
    @GetMapping("/get_by_colournameandsizename/{colourname}/{sizename}")
    public List<Product_details> getProductsByColournameAndSizename(@PathVariable(name = "colourname") String colourname,@PathVariable(name = "sizename") String sizename){
//    System.out.println(colourid);
        return productService.getProductsByColournameAndSizename(colourname,sizename);
    }
    @GetMapping("/get_by_colournameandsizenameandcategory/{colourname}/{sizename}/{category}")
    public List<Product_details> getProductsByColournameAndSizename(@PathVariable(name = "colourname") String colourname,@PathVariable(name = "sizename") String sizename,@PathVariable(name="category") String category){
//    System.out.println(colourid);
        return productService.getProductsByColournameAndSizenameAndCategory(colourname,sizename,category);
    }
    @GetMapping("/get_by_colournameandsizenameandcategoryandfabrictype/{colourname}/{sizename}/{category}/{fabrictype}")
    public List<Product_details> getProductsByColournameAndSizenameAndFabricType(@PathVariable(name = "colourname") String colourname,@PathVariable(name = "sizename") String sizename,@PathVariable(name="category") String category, @PathVariable(name="fabrictype") String fabrictype){
//    System.out.println(colourid);
        return productService.getProductsByColournameAndSizenameAndCategoryAndFabrictype(colourname,sizename,category,fabrictype);
    }
    @GetMapping("/get_by_colournameandcategory/{colourname}/{category}")
    public List<Product_details> getProductsByColournameAndCategory(@PathVariable(name = "colourname") String colourname,@PathVariable(name="category") String category){
//    System.out.println(colourid);
        return productService.getProductsByColournameAndCategory(colourname,category);
    }
    @GetMapping("/get_by_sizenameandcategory/{sizename}/{category}")
    public List<Product_details> getProductsBySizenameAndCategory(@PathVariable(name = "sizename") String sizename,@PathVariable(name="category") String category){
//    System.out.println(colourid);
        return productService.getProductsBySizenameAndCategory(sizename,category);
    }
    @GetMapping("/get_by_fabrictypeandcategory/{fabrictype}/{category}")
    public List<Product_details> getProductsByFabrictypeAndCategory(@PathVariable(name = "fabrictype") String fabrictype,@PathVariable(name="category") String category){
//    System.out.println(colourid);
        return productService.getProductsByFabrictypeAndCategory(fabrictype,category);
//        getProductsByFabrictypeAndCategory(fabrictype,category);
    }
}
