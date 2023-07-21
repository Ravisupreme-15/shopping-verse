package com.example.shoppingverse.repository;

import com.example.shoppingverse.model.Customer;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository  extends JpaRepository<Customer , Integer> {
}
