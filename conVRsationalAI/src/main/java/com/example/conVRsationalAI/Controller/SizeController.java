package com.example.conVRsationalAI.Controller;

import com.example.conVRsationalAI.Entity.Size;
import com.example.conVRsationalAI.Services.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SizeController {
    @Autowired
    SizeService sizeService;
    @PostMapping("/size")
    public Size insertSize(@RequestBody Size size) {
        return sizeService.insertSize(size);
    }

    @GetMapping("/size")
    public List<Size> getAll() {
        return sizeService.getAll();
    }
    @GetMapping("/size/{size_name}")
    public Size getSize(@PathVariable(value = "size_name") String size_name){
        return sizeService.getSize(size_name);
    }
}
