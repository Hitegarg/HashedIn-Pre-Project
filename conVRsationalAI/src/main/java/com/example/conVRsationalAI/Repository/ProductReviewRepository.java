package com.example.conVRsationalAI.Repository;


import com.example.conVRsationalAI.Entity.Product_review;
import com.example.conVRsationalAI.Entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReviewRepository extends JpaRepository<Product_review,Integer> {
    Product_review findById(int id);
    Boolean existsById(int id);
}
