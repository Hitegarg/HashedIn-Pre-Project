package com.example.conVRsationalAI.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
@Data
@Entity
public class Colour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int colour_id;
    int colour_name;
    Date created_date;
    String created_by;
    Date modified_date;
    String modified_by;
}
