package com.example.conVRsationalAI.Services;

import com.example.conVRsationalAI.Entity.Cart;
import com.example.conVRsationalAI.Entity.Product_details;
import com.example.conVRsationalAI.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;
    double sum= 0;
    public Cart insertintoCart(Cart cart2) {
        cart2.getCart_items().forEach( productDetails1 ->  sum += productDetails1.getAmount());
        cart2.setTotal_amount(sum);
        return cartRepository.save(cart2);
    }

    public double getTotalAmount(Cart cart , int id){
        Cart cart1 = cartRepository.findById(id);
        cart1.getCart_items().forEach( productDetails1 ->  sum += productDetails1.getAmount());
        return sum;
    }

    public Cart getCart(int id){

        return cartRepository.findById(id);
    }
    public List<Cart> getCartItems(){
        return cartRepository.findAll();
    }
    public void deleteCart(int id) {
        if (cartRepository.existsById(id)) {
            cartRepository.deleteById(id);
        }
    }

    public Cart updateCartItems(Cart cart , int id){
       Cart cart1 = cartRepository.findById(id);
       cart1.setCart_items(cart.getCart_items());
       return cartRepository.save(cart1);
    }

}
