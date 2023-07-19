package com.example.shoppingverse.model;


import com.example.shoppingverse.Enum.PrdStatus;
import com.example.shoppingverse.Enum.prdCategory;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "product")
public class Product  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    String productName;

    int price;

    int availableQty;

    prdCategory category;

    PrdStatus status;


    @ManyToOne
    @JoinColumn
    Seller seller;

    @OneToMany(mappedBy = "product",cascade =  CascadeType.ALL)
    List<Item> itemList = new ArrayList<>();
}
