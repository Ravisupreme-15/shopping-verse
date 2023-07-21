package com.example.shoppingverse.controller;

import com.example.shoppingverse.dto.reqDto.SellerReqDto;
import com.example.shoppingverse.dto.resDto.SellerResDto;
import com.example.shoppingverse.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;


    @PostMapping("/add-customer")
    public ResponseEntity addNewSeller(@RequestBody SellerReqDto sellerReqDto){

        SellerResDto sellerResDto  = sellerService.addNewSeller(sellerReqDto);

        return new ResponseEntity(sellerResDto, HttpStatus.ACCEPTED);
    }
}
