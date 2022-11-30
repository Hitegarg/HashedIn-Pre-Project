package com.example.conVRsationalAI.Entity;


import com.example.conVRsationalAI.Common.Gender;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Data
@Entity
public class Product_details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int product_id;

    @OneToMany(cascade = CascadeType.ALL)
    Set<Size> sizes;

    @OneToMany(cascade = CascadeType.ALL)
    Set<Colour> colours;

    String fabric_type;
    String category;
    double amount;
    Gender gender;
    String description;
    Date created_date;
    String created_by;
    Date modified_date;
    String modified_by;
}
