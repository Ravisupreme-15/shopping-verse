package com.example.shoppingverse.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.lang.model.element.NestingKind;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "order_info")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    String orderId;

    @CreationTimestamp
    Date orderDate;

    String cardUsed;

    int orderTotal;

    @OneToMany(mappedBy = "orderEntity",cascade = CascadeType.ALL)
    List<Item> itemList = new ArrayList<>();


    @ManyToOne
    @JoinColumn
    Customer customer;
}