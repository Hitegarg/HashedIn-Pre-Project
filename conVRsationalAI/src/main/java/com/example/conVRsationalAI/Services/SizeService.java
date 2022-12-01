package com.example.conVRsationalAI.Services;

import com.example.conVRsationalAI.Entity.Size;
import com.example.conVRsationalAI.Repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class SizeService {
    @Autowired
    SizeRepository sizeRepository;
    public Size insertSize(Size size) {
        size.setCreated_by("Admin");
        size.setCreated_date(Date.valueOf("2022-04-23"));
        size.setModified_date(Date.valueOf("2022-04-23"));
        size.setModified_by("Admin");
        return sizeRepository.save(size);
    }
    public Size getSize(String name){
        return sizeRepository.findBySizename(name);
    }
    public List<Size> getAll() {
        return sizeRepository.findAll();
    }

}
