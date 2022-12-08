package com.example.conVRsationalAI.Repository;

import com.example.conVRsationalAI.Entity.Colour;
import com.example.conVRsationalAI.Entity.Product_details;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ProductRepository extends JpaRepository<Product_details, Integer> {
    Product_details findByCategory(String category);
    Product_details findByProductid(int productid);
//    Product_details findByColours(Set<Colour> colour);
    List<Product_details> findByColoursColourid(int colourid);
    List<Product_details> findByColoursColourname(String colourname);
    List<Product_details> findBySizesSizeid(int sizeid);
    List<Product_details> findBySizesSizename(String sizename);
    List<Product_details> findByColoursColournameAndSizesSizename(String colourname, String sizename);
    List<Product_details> findByColoursColournameAndSizesSizenameAndCategory(String colourname, String sizename, String category);
    List<Product_details> findByColoursColournameAndSizesSizenameAndCategoryAndFabrictype(String colourname, String sizename, String category, String fabrictype);
    List<Product_details> findByColoursColournameAndCategory(String colourname, String category);
    List<Product_details> findBySizesSizenameAndCategory(String sizename, String category);
    List<Product_details> findByFabrictypeAndCategory(String fabrictype, String category);
}
