package com.example.conVRsationalAI.Controller;

import com.example.conVRsationalAI.Entity.Cart;
import com.example.conVRsationalAI.Entity.Product_review;
import com.example.conVRsationalAI.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/insertCart")
    public Cart insertTheCart(@RequestBody Cart cart) {
        return cartService.insertintoCart(cart);
    }

    @GetMapping("/getAllCarts")
    public List<Cart> getAllCarts() {
        return cartService.getCartItems();
    }

    @DeleteMapping("/deleteCartById/{id}")
    public void deleteCart(@PathVariable(value = "id") int id) {
        cartService.deleteCart(id);
    }

    @GetMapping("/getCartById/{id}")
    public Cart getCartById(@PathVariable(value = "id") int id){
        return cartService.getCart(id);
    }

    @PutMapping("/updateCart/{id}")
    public Cart updateCart(@RequestBody Cart cart , @PathVariable(value = "id") int id){

        return cartService.updateCartItems(cart,id);
    }

}
