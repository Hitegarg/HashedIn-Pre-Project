package com.example.conVRsationalAI.Controller;

import com.example.conVRsationalAI.Entity.Colour;
import com.example.conVRsationalAI.Entity.UserCredentials;
import com.example.conVRsationalAI.Services.ColourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ColourController {

    @Autowired
    ColourService colourService;

    @PostMapping("/colour")
    public Colour insertColour(@RequestBody Colour colour) {
        return colourService.insertColour(colour);
    }

    @GetMapping("/colour")
    public List<Colour> getAll() {
        return colourService.getAll();
    }

    @GetMapping("/colour/{colour_name}")
    public Colour getColour(@PathVariable(value = "colour_name") String colour_name){
        return colourService.getColour(colour_name);
    }
}
