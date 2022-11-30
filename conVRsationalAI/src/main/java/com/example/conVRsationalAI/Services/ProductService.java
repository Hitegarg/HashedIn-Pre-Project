package com.example.conVRsationalAI.Services;

import com.example.conVRsationalAI.Entity.Colour;
import com.example.conVRsationalAI.Entity.Product_details;
import com.example.conVRsationalAI.Repository.ColourRepository;
import com.example.conVRsationalAI.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public Product_details insertProduct(Product_details product_details) {
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
}
