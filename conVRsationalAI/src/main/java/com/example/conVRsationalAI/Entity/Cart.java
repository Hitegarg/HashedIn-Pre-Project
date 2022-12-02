package com.example.conVRsationalAI.Entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartid;
    @OneToOne
    private UserCredentials userCredentials;
    @ManyToMany
    Set<Product_details> cart_items;
    Double total_amount;
    Date created_date;
    String created_by;
    Date modified_date;
    String modified_by;

}
