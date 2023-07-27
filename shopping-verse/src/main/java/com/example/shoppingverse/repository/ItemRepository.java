package com.example.shoppingverse.repository;

import com.example.shoppingverse.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository  extends JpaRepository<Item,Integer> {
}
