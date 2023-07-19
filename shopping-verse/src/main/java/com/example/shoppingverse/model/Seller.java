package com.example.shoppingverse.model;


import com.example.shoppingverse.Enum.Gender;
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
@Table(name = "seller")
public class Seller {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    String name;

    @Column(unique = true, nullable = false)
    String emailId;

    @Column(unique = true,nullable = false)
    String panNo;

    @Column(unique = true,nullable = false)
    String mobileNo;

    Gender gender;

    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
   List<Product> productList = new ArrayList<>();





}
