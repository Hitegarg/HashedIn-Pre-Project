package com.example.conVRsationalAI.Controller;

import com.example.conVRsationalAI.Entity.Order_detail;
import com.example.conVRsationalAI.Services.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderDetailController {

    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping("/order-detail/{order_id}")
    public List<Order_detail> getAllOrders(@PathVariable(value = "order_id") Long order_id){
        return orderDetailService.getAllOrders(order_id);
    }

    @PostMapping("/order-detail")
    public Order_detail insertOrderDetail(@RequestBody Order_detail order_detail){
        return orderDetailService.insertOrderDetail(order_detail);
    }

}
