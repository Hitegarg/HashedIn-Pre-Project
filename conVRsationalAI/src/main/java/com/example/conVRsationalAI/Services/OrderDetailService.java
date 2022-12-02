package com.example.conVRsationalAI.Services;

import com.example.conVRsationalAI.Entity.Order_detail;
import com.example.conVRsationalAI.Repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    public List<Order_detail> getAllOrders(Long order_id) {
        return orderDetailRepository.findByOrderId(order_id);
    }

    public Order_detail insertOrderDetail(Order_detail order_detail) {
        return orderDetailRepository.save(order_detail);
    }
}
