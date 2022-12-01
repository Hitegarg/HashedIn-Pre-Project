package com.example.conVRsationalAI.Repository;

import com.example.conVRsationalAI.Entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository extends JpaRepository<Size,Integer> {
    Size findBySizename(String size_name);
}
