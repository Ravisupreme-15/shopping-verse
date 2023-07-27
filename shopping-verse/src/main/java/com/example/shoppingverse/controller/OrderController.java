package com.example.shoppingverse.controller;


import com.example.shoppingverse.dto.reqDto.OrderReqDto;
import com.example.shoppingverse.dto.resDto.OrderResDto;
import com.example.shoppingverse.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired

    OrderService orderService;

     @PostMapping("/PlaceOrder")
    public ResponseEntity  placeOrder(@RequestBody OrderReqDto orderReqDto){

       try {
            OrderResDto orderResDto = orderService.placeOrder(orderReqDto);
            return new ResponseEntity(orderResDto, HttpStatus.ACCEPTED);
        }
        catch (Exception e){

           return new ResponseEntity(e.getMessage(),HttpStatus.ACCEPTED);

        }
    }

}
