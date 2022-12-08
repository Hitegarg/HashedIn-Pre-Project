package com.example.conVRsationalAI.Repository;

import com.example.conVRsationalAI.Entity.Colour;
import com.example.conVRsationalAI.Entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColourRepository extends JpaRepository<Colour,Integer> {
    Colour findByColourname(String colour_name);
    Colour findByColourid(int colourid);

}
