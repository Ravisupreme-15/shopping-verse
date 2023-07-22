package com.example.shoppingverse.repository;

import com.example.shoppingverse.Enum.PrdCategory;
import com.example.shoppingverse.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {



    @Query(value = "select p from Product p where p.category= :prdCategory and p.price>= :price")
   public List<Product> getPrdByCategoryAndPriceGreaterThan(PrdCategory prdCategory, int price);


}
