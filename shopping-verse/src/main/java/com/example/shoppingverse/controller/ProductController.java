package com.example.shoppingverse.controller;


import com.example.shoppingverse.dto.reqDto.ProductReqDto;
import com.example.shoppingverse.dto.resDto.ProductResDto;
import com.example.shoppingverse.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
