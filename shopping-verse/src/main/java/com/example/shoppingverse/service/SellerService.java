package com.example.shoppingverse.service;

import com.example.shoppingverse.dto.reqDto.SellerReqDto;
import com.example.shoppingverse.dto.resDto.SellerResDto;
import com.example.shoppingverse.model.Seller;
import com.example.shoppingverse.repository.SellerRepository;
import com.example.shoppingverse.transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SellerService {

   @Autowired
   SellerRepository sellerRepository;


    public SellerResDto addNewSeller(SellerReqDto sellerReqDto) {


            // dto - entiy

        Seller seller  = SellerTransformer.SellerReqDtoToEntity(sellerReqDto);


        Seller savedSeller = sellerRepository.save(seller);


        SellerResDto sellerResDto = SellerTransformer.SellerEntityToResDto(savedSeller);

        return sellerResDto;
    }
}
