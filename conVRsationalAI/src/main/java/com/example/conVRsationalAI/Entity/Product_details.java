package com.example.conVRsationalAI.Entity;

import com.example.conVRsationalAI.Common.GENDER;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Data
@Entity
public class Product_details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int product_id;
    @ManyToMany
    Set<Size> sizes;
    @ManyToMany
    Set<Colour> colours;
    String fabric_type;
    String category;
    double amount;
    GENDER gender;
    String description;
    Date created_date;
    String created_by;
    Date modified_date;
    String modified_by;

}
