package com.example.conVRsationalAI.Services;

import com.example.conVRsationalAI.Entity.Cart;
import com.example.conVRsationalAI.Entity.Product_review;
import com.example.conVRsationalAI.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    public Cart insertintoCart(Cart cart) {



        return cartRepository.save(cart);
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
