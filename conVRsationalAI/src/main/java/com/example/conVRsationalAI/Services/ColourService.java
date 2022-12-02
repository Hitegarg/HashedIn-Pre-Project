package com.example.conVRsationalAI.Services;

import com.example.conVRsationalAI.Entity.Colour;
import com.example.conVRsationalAI.Entity.UserCredentials;
import com.example.conVRsationalAI.Repository.ColourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ColourService {
    @Autowired
    ColourRepository colourRepository;
    public Colour insertColour(Colour colour) {
//        colour.setCreated_by("Admin");
//        colour.setCreated_date(Date.valueOf("2022-04-23"));
//        colour.setModified_date(Date.valueOf("2022-04-23"));
//        colour.setModified_by("Admin");
        return colourRepository.save(colour);
    }
    public Colour getColour(String name){
        return colourRepository.findByColourname(name);
    }
    public List<Colour> getAll() {

        return colourRepository.findAll();
    }
}
