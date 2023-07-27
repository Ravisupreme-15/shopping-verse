package com.example.shoppingverse.transformer;

import com.example.shoppingverse.dto.reqDto.CardReqDto;
import com.example.shoppingverse.dto.resDto.CardResDto;
import com.example.shoppingverse.model.Card;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;


public class CardTransformer {


    public static Card CardReqDtoToEntity(CardReqDto cardReqDto){


             return  Card.builder()
                     .cardNo(cardReqDto.getCardNo())
                     .cardType(cardReqDto.getCardType())
                     .cvv(cardReqDto.getCvv())
                     .validTill(cardReqDto.getValidTill())
                     .build();
    }

    public static CardResDto CardEntityToResDto(Card card) {


             return  CardResDto.builder()
                     .cardType(card.getCardType())
                     .cardNo(getMaskedCardNo(card.getCardNo()))
                     .customerName(card.getCustomer().getName())
                     .validTill(card.getValidTill())
                      .build();
    }

    public static String getMaskedCardNo(String cardNo) {

          String ans="";

          String lastFoudDigits = cardNo.substring(cardNo.length()-4);

          for(int i=0;i<cardNo.length()-4;i++){

               ans+="x";
          }

          return ans+lastFoudDigits;
    }
}
