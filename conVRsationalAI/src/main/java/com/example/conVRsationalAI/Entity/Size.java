package com.example.conVRsationalAI.Entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int size_id;
    String sizename;
    Date created_date;
    String created_by;
    Date modified_date;
    String modified_by;
}
