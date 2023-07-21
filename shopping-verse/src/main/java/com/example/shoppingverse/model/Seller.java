package com.example.shoppingverse.model;


import com.example.shoppingverse.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
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

     @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
   List<Product> productList = new ArrayList<>();





}
