package com.example.shoppingverse.transformer;

import com.example.shoppingverse.dto.reqDto.SellerReqDto;
import com.example.shoppingverse.dto.resDto.SellerResDto;
import com.example.shoppingverse.model.Seller;

public class SellerTransformer {

    public  static Seller SellerReqDtoToEntity(SellerReqDto sellerReqDto){

           return   Seller.builder()
                   .name(sellerReqDto.getName())
                   .mobileNo(sellerReqDto.getMobileNo())
                   .emailId(sellerReqDto.getEmailId())
                   .panNo(sellerReqDto.getPanNo())
                   .gender(sellerReqDto.getGender())
                   .build();
    }

    public static SellerResDto SellerEntityToResDto(Seller seller){

         return SellerResDto.builder()
                 .emailId(seller.getEmailId())
                 .name(seller.getName())
                 .build();
    }
}
