package com.example.shoppingverse.controller;


import com.example.shoppingverse.dto.reqDto.CardReqDto;
import com.example.shoppingverse.dto.resDto.CardResDto;
import com.example.shoppingverse.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {

   @Autowired
   CardService cardService;

    // add new Card

    @PostMapping("/addNewCard")
    public ResponseEntity addNewCard(@RequestBody  CardReqDto cardReqDto){


       try {
            CardResDto cardResDto = cardService.addNewCard(cardReqDto);
            return new ResponseEntity(cardResDto,HttpStatus.ACCEPTED);
        }
       catch (Exception e){
             return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
       }

    }


}
