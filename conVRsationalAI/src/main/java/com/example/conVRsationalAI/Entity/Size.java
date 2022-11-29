package com.example.conVRsationalAI.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Data
@Entity
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int size_id;
    int size_name;
    Date created_date;
    String created_by;
    Date modified_date;
    String modified_by;
}
