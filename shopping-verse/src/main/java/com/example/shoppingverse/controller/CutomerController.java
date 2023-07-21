package com.example.shoppingverse.controller;


import com.example.shoppingverse.dto.reqDto.CustomerReqDto;
import com.example.shoppingverse.dto.resDto.CustomerResDto;
import com.example.shoppingverse.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CutomerController {

    @Autowired
    CustomerService customerService;

    // add new customer
    @PostMapping("/addNewCustomer")
    public ResponseEntity addNewCutomer(@RequestBody  CustomerReqDto customerReqDto){


        CustomerResDto customerResDto = customerService.addNewCustomer(customerReqDto);

        return new ResponseEntity(customerReqDto, HttpStatus.ACCEPTED);
    }
}
