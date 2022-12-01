package com.example.conVRsationalAI.Entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Data
public class Product_review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int review_id;
    @OneToOne(cascade = {CascadeType.ALL})
    private Product_details product_details;
    @OneToOne(cascade = {CascadeType.ALL})
    private UserCredentials userCredentials;
    String content;
    Date created_date;
    String created_by;
    Date modified_date;
    String modified_by;


}
