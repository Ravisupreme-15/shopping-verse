package com.example.shoppingverse.model;

import com.example.shoppingverse.Enum.CardType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="card")
@Builder
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true)
    String cardNo;

    int cvv;

    @Enumerated(EnumType.STRING)
    CardType cardType;


    Date validTill;


    @ManyToOne
    @JoinColumn
    Customer customer;
}
