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
@Table(name = "customer")
public class Customer{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Column(unique = true)
    String emailId;

    @Column(unique = true)
    String mobileNo;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    Cart cart;

    @OneToMany(mappedBy ="customer",cascade = CascadeType.ALL)
    List<Card> cardList = new ArrayList<>();



    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<OrderEntity> orderEntities = new ArrayList<>();
}

