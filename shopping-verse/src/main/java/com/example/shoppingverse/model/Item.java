package com.example.shoppingverse.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int requiredQty;

    @ManyToOne
    @JoinColumn
    Cart cart;

    @ManyToOne
    @JoinColumn
    Product product;


    @ManyToOne
    @JoinColumn
    OrderEntity orderEntity;
}
