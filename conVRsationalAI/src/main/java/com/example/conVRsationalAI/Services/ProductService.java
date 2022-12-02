package com.example.conVRsationalAI.Services;

import com.example.conVRsationalAI.Entity.Colour;
import com.example.conVRsationalAI.Entity.Product_details;
import com.example.conVRsationalAI.Repository.ColourRepository;
import com.example.conVRsationalAI.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ColourRepository colourRepository;
    public Product_details insertProduct(Product_details product_details) {
//        Product_details p = new Product_details();
//        Colour c = new Colour();
//        if(product_details.getColours().)
//        p.setColours(c.getColour_id());
        ArrayList<Integer>c = new ArrayList<>();
        System.out.println(product_details.getSizes());
        product_details.getColours().forEach(colour -> c.add(colour.getColour_id()) );
        System.out.println(c);
        product_details.setCreated_by("Admin");
        product_details.setCreated_date(Date.valueOf("2022-04-23"));
        product_details.setModified_date(Date.valueOf("2022-04-23"));
        product_details.setModified_by("Admin");
        return productRepository.save(product_details);
    }

//    public void searchOnColour(String colour){
//
//        System.out.println(productDetails.getColours());
//    }

    public Product_details getProduct(String category){
        return productRepository.findByCategory(category);
    }
    public List<Product_details> getAll() {
        return productRepository.findAll();
    }
}
