package com.example.shoppingverse.service;

import com.example.shoppingverse.dto.reqDto.ProductReqDto;
import com.example.shoppingverse.dto.resDto.ProductResDto;
import com.example.shoppingverse.exception.SellerNotFoundException;
import com.example.shoppingverse.model.Product;
import com.example.shoppingverse.model.Seller;
import com.example.shoppingverse.repository.ProductRepository;
import com.example.shoppingverse.repository.SellerRepository;
import com.example.shoppingverse.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;

    public ProductResDto addProduct(ProductReqDto productReqDto) {


         Seller seller =  sellerRepository.findByEmailId(productReqDto.getEmailId());


         if(seller==null){
             throw new SellerNotFoundException("Inavli Seller emailId");
         }


         // dto to entity

         Product product = ProductTransformer.ProductReqDtoToEntity(productReqDto);

         product.setSeller(seller);

         seller.getProductList().add(product);

         Seller  savedSeller  = sellerRepository.save(seller);

         List<Product> productList = savedSeller.getProductList();

         Product savedProduct = productList.get(productList.size()-1);

          // entity - dto
        ProductResDto productResDto  = ProductTransformer.ProdctEntityToResDto(savedProduct);

        return productResDto;

    }
}
