package com.example.conVRsationalAI.Repository;

import com.example.conVRsationalAI.Entity.Product_details;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product_details, Integer> {
    Product_details findByCategory(String category);
}
