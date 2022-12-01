package com.example.conVRsationalAI.Services;

import com.example.conVRsationalAI.Entity.Product_review;
import com.example.conVRsationalAI.Repository.ProductReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ProductReviewService {
    @Autowired
    ProductReviewRepository productReviewRepository;

    public Product_review insertReview(Product_review review) {
        return productReviewRepository.save(review);
    }

    public Product_review getReviewById(int id){
        return productReviewRepository.findById(id);
    }
    public List<Product_review> getReview(){
        return productReviewRepository.findAll();
    }
    public void deleteReviews(int id) {
        if (productReviewRepository.existsById(id)) {
            productReviewRepository.deleteById(id);
        }
    }

    public Product_review updateProductReview(Product_review product_review){
        Optional<Product_review> review = Optional.ofNullable(productReviewRepository.findById(product_review.getReview_id()));
        if(review.isEmpty()){
            return new Product_review();
        }
        productReviewRepository.deleteById(productReviewRepository.findById(product_review.getReview_id()).getReview_id());
        Product_review productreview = review.get();
        productreview.setContent(productreview.getContent());
        return productReviewRepository.save(productreview);
    }


    public Product_review updateReview(int id , Product_review product){
        Product_review productReview = productReviewRepository.findById(id);
        productReview.setContent(product.getContent());
        return productReviewRepository.save(productReview);
    }

}

