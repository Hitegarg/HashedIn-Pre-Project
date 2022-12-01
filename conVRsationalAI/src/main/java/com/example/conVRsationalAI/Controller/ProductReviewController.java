package com.example.conVRsationalAI.Controller;

import com.example.conVRsationalAI.Entity.Product_review;
import com.example.conVRsationalAI.Entity.UserCredentials;
import com.example.conVRsationalAI.Services.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ProductReviewController {

    @Autowired
    ProductReviewService productReviewService;

    @PostMapping("/insertReview")
    public Product_review insertTheReview(@RequestBody Product_review product_review) {
        return productReviewService.insertReview(product_review);
    }

    @GetMapping("/getAllReviews")
    public List<Product_review> getAllReview() {
        return productReviewService.getReview();
    }

    @DeleteMapping("/deleteReviewById/{id}")
    public void deleteReview(@PathVariable(value = "id") int id) {
        productReviewService.deleteReviews(id);
    }

    @GetMapping("/getReviewById/{id}")
    public Product_review getReviewsById(@PathVariable(value = "id") int id){
        return productReviewService.getReviewById(id);
    }

    @PutMapping("/updateReview/{id}")
    public Product_review updateReviews(@RequestBody Product_review product_review , @PathVariable(value = "id") int review_id){
            return productReviewService.updateReview(review_id,product_review);
    }

}