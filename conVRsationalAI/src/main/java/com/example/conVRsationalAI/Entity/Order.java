package com.example.conVRsationalAI.Entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    Long userId;
    Date order_date;
    String status;

    Date created_date;
    String created_by;
    Date modified_date;
    String modified_by;
}
