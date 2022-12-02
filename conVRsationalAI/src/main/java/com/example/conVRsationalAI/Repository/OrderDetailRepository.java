package com.example.conVRsationalAI.Repository;

import com.example.conVRsationalAI.Entity.Order_detail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository  extends JpaRepository<Order_detail, Long> {

    List<Order_detail> findByOrderId(Long OrderId);
}
