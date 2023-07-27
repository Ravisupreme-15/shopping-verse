package com.example.shoppingverse.controller;


import com.example.shoppingverse.dto.reqDto.ItemReqDto;
import com.example.shoppingverse.dto.resDto.CartResDto;
import com.example.shoppingverse.model.Item;
import com.example.shoppingverse.service.CartService;
import com.example.shoppingverse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {


    @Autowired

    CartService cartService;


    @Autowired
    ItemService itemService;

    // add item to the cart
    public ResponseEntity addItemToCart(ItemReqDto itemReqDto){

        try{
            Item item = itemService.creatItem(itemReqDto);

            CartResDto cartResDto = cartService.addItemToCart(itemReqDto, item);

            return new ResponseEntity(cartResDto, HttpStatus.ACCEPTED);
        }
        catch (Exception e){

            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }


}
