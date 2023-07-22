package com.example.shoppingverse.controller;


import com.example.shoppingverse.Enum.PrdCategory;
import com.example.shoppingverse.dto.reqDto.ProductReqDto;
import com.example.shoppingverse.dto.resDto.ProductResDto;
import com.example.shoppingverse.service.ProductService;
import jakarta.persistence.GeneratedValue;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/addNewProd")
    public ResponseEntity addProduct(@RequestBody ProductReqDto productReqDto){

        try {
            ProductResDto productResDto = productService.addProduct(productReqDto);
            return new ResponseEntity(productResDto, HttpStatus.ACCEPTED);
        }
        catch (Exception e){

            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
         }
    }




    // get products by category and price greaterthan

    @GetMapping("/get-prd-by-price-category")
    public ResponseEntity getPrdByCategoryAndPriceGreaterThan(@RequestParam("category")PrdCategory prdCategory,@RequestParam("price") int price){


            List<ProductResDto> list = productService.getPrdByCategoryAndPriceGreaterThan(prdCategory, price);

            if(list.isEmpty()) return new ResponseEntity("List is empty",HttpStatus.NO_CONTENT);


            return new ResponseEntity(list,HttpStatus.FOUND);


    }
}
