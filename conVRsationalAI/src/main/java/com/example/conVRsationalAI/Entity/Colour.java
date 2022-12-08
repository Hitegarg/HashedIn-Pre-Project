package com.example.conVRsationalAI.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Colour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int colourid;
    String colourname;
    Date created_date;
    String created_by;
    Date modified_date;
    String modified_by;
    @ManyToMany(mappedBy = "colours", cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JsonIgnoreProperties("colours")
    List<Product_details> products;

    public Colour(String colourname, List<Product_details> products,Date created_date, String created_by, Date modified_date, String modified_by) {
        this.colourname = colourname;
        this.products = products;
        this.created_by=created_by;
        this.created_date=created_date;
        this.modified_by=modified_by;
        this.modified_date=modified_date;
    }
}
