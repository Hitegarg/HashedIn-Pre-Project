package com.example.conVRsationalAI.Services;

import com.example.conVRsationalAI.Entity.Colour;
import com.example.conVRsationalAI.Entity.Product_details;
import com.example.conVRsationalAI.Entity.UserCredentials;
import com.example.conVRsationalAI.Repository.ColourRepository;
import com.example.conVRsationalAI.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ColourRepository colourRepository;
    public Product_details insertProduct(Product_details product_details) {
//        Colour newcolour = new Colour();
//        newcolour= colourRepository.findByColourid(product_details.getColours())
        product_details.setCreated_by("Admin");
        product_details.setCreated_date(Date.valueOf("2022-04-23"));
        product_details.setModified_date(Date.valueOf("2022-04-23"));
        product_details.setModified_by("Admin");
        return productRepository.save(product_details);
    }
    public Product_details getProduct(String category){
        return productRepository.findByCategory(category);
    }
    public List<Product_details> getAll() {
        return productRepository.findAll();
    }
//    public Product_details updateProductDetails(Product_details product_details){
//        Optional<Product_details> product=productRepository.findById(productRepository.findByCategory(product_details.getCategory()).getProductid());
//        if(product.isEmpty()){
//            return new Product_details();
//        }
//        productRepository.deleteById(productRepository.findByCategory(product_details.getCategory()).getProductid());
//        Product_details newproduct=product.get();
//        newproduct.setAmount(product_details.getAmount());
//        newproduct.setFabric_type(product_details.getFabric_type());
//        return productRepository.save(newproduct);
//    }
    public Product_details updateProductdetails(int productid , Product_details productdetails){
        Product_details product = productRepository.findByProductid(productid);
        product.setFabrictype(productdetails.getFabrictype());
        product.setCategory(productdetails.getCategory());
        product.setAmount(productdetails.getAmount());
        return productRepository.save(product);
    }
//    public Product_details findByColour(String colourname){
//        Colour colour = colourRepository.findByColourname(colourname);
//        Set<Colour> newcolour = new HashSet<>();
////        Product_details product_details=new Product_details();
////        product_details.getColours()
//        newcolour.add(colour);
//        return productRepository.findByColours(newcolour);
//    }

    public List<Product_details> getProductsByColourid(int colourid){
        return productRepository.findByColoursColourid(colourid);
    }
    public List<Product_details> getProductsByColourname(String colourname){
        return productRepository.findByColoursColourname(colourname);
    }
    public List<Product_details> getProductsBySizeid(int sizeid){
        return productRepository.findBySizesSizeid(sizeid);
    }
    public List<Product_details> getProductsBySizename(String sizename){
        return productRepository.findBySizesSizename(sizename);
    }
    public List<Product_details> getProductsByColournameAndSizename(String colourname, String sizename){
        return productRepository.findByColoursColournameAndSizesSizename(colourname,sizename);
    }
    public List<Product_details> getProductsByColournameAndSizenameAndCategory(String colourname, String sizename, String category){
        return productRepository.findByColoursColournameAndSizesSizenameAndCategory(colourname,sizename,category);
    }
    public List<Product_details> getProductsByColournameAndSizenameAndCategoryAndFabrictype(String colourname, String sizename, String category, String fabrictype){
        return productRepository.findByColoursColournameAndSizesSizenameAndCategoryAndFabrictype(colourname,sizename,category,fabrictype);
    }
    public List<Product_details> getProductsByColournameAndCategory(String colourname,String category){
        return productRepository.findByColoursColournameAndCategory(colourname,category);
    }
    public List<Product_details> getProductsBySizenameAndCategory(String sizename,String category){
        return productRepository.findBySizesSizenameAndCategory(sizename,category);
    }
    public List<Product_details> getProductsByFabrictypeAndCategory(String fabrictype,String category){
        return productRepository.findByFabrictypeAndCategory(fabrictype,category);
    }
}
