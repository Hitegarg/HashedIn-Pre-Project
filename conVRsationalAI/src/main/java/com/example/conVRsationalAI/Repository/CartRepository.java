package com.example.conVRsationalAI.Repository;

import com.example.conVRsationalAI.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    Cart findById(int id);
    Boolean existsById(int id);
}
