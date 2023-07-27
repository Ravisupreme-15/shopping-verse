package com.example.shoppingverse.repository;

import com.example.shoppingverse.model.OrderEntity;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Integer>{
}
