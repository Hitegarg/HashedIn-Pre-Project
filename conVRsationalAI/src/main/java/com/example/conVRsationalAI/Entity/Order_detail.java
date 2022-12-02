package com.example.conVRsationalAI.Entity;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;
import java.util.Map;

@Data
@Entity
public class Order_detail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    Throwing Error
//    To store Product and Quantity
//    @OneToMany(cascade = CascadeType.ALL)
//    Map<Product_details, Integer> products;

    Long orderId;
    double total_amount;
    int total_quantity;
    String address;
    Date created_date;
    String created_by;
}
