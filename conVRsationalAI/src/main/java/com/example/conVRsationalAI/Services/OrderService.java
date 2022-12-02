package com.example.conVRsationalAI.Services;

import com.example.conVRsationalAI.Entity.Order;
import com.example.conVRsationalAI.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order insertOrder(Order order) {
        order.setOrder_date(Date.valueOf(LocalDate.now()));
        order.setCreated_by("Admin");
        order.setCreated_date(Date.valueOf(LocalDate.now()));
        order.setModified_date(Date.valueOf(LocalDate.now()));
        order.setModified_by("Admin");
        return orderRepository.save(order);
    }
//    public Order getOrder(Long order_id){
//        return orderRepository.findById(order_id);
//    }

    public List<Order> getAll(Long user_id) {
        return orderRepository.findByUserId(user_id);
    }
}
