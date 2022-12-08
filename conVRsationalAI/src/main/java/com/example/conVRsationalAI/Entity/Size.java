package com.example.conVRsationalAI.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int sizeid;
    String sizename;
    Date created_date;
    String created_by;
    Date modified_date;
    String modified_by;
    @ManyToMany(mappedBy = "sizes", cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JsonIgnoreProperties("sizes")
    List<Product_details> products;

    public Size(String sizename, List<Product_details> products,Date created_date, String created_by, Date modified_date, String modified_by) {
        this.sizename = sizename;
        this.products = products;
        this.created_by=created_by;
        this.created_date=created_date;
        this.modified_by=modified_by;
        this.modified_date=modified_date;
    }
}
