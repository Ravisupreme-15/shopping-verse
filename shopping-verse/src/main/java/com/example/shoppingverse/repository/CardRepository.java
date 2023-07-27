package com.example.shoppingverse.repository;

import com.example.shoppingverse.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {
    Card findByCardNo(String cardUsed);
}
