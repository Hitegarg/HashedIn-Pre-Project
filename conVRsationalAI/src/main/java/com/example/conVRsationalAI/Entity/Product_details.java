package com.example.conVRsationalAI.Entity;

import com.example.conVRsationalAI.Common.GENDER;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product_details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int productid;
//    @ManyToMany
//    Set<Size> sizes;
//    @ManyToMany
//    Set<Colour> colours;
    String fabrictype;
    String category;
    double amount;
    GENDER gender;
    String description;
    Date created_date;
    String created_by;
    Date modified_date;
    String modified_by;
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name = "Product_Color_Table",
            joinColumns = {
                    @JoinColumn(name = "product_id",referencedColumnName = "productid")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "colour_id",referencedColumnName = "colourid")
            }
    )
    @JsonIgnoreProperties("products")
    List<Colour> colours;
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name = "Product_Size_Table",
            joinColumns = {
                    @JoinColumn(name = "product_id",referencedColumnName = "productid")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "size_id",referencedColumnName = "sizeid")
            }
    )
    @JsonIgnoreProperties("products")
    List<Size> sizes;
    public Product_details(String fabrictype, String category, double amount, GENDER gender, String description, Date created_date, String created_by, Date modified_date, String modified_by ,List<Colour> colours, List<Size> sizes) {
        this.fabrictype = fabrictype;
        this.description = description;
        this.category=category;
        this.amount=amount;
        this.gender=gender;
        this.created_by=created_by;
        this.created_date=created_date;
        this.modified_by=modified_by;
        this.modified_date=modified_date;
        this.colours = colours;
        this.sizes=sizes;
    }

    public void addColor(Colour colour){
        colours.add(colour);
    }
    public void addSize(Size size){
        sizes.add(size);
    }
}
