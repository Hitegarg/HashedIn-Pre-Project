package com.example.conVRsationalAI.Repository;

import com.example.conVRsationalAI.Entity.Colour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ColourRepository extends JpaRepository<Colour,Integer> {
    Colour findByColourname(String colour_name);


}
