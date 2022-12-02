package com.example.conVRsationalAI.Controller;

import com.example.conVRsationalAI.Entity.Order;
import com.example.conVRsationalAI.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public Order insertOrder(@RequestBody Order order) {
        return orderService.insertOrder(order);
    }

//    @GetMapping("/order/{order_id}")
//    public Order getOrder(@PathVariable(value = "order_id") Long order_id){
//        System.out.println(order_id);
//        return orderService.getOrder(order_id).get();
//    }

    @GetMapping("/order/{user_id}")
    public List<Order> getAllOrders(@PathVariable(value = "user_id") Long user_id) {
        System.out.println(user_id);
        return orderService.getAll(user_id);
    }

}
