package com.example.shoppingverse.transformer;

import com.example.shoppingverse.dto.resDto.CartResDto;
import com.example.shoppingverse.dto.resDto.ItemResDto;
import com.example.shoppingverse.model.Cart;
import com.example.shoppingverse.model.Item;

import java.util.ArrayList;
import java.util.List;

public class CartTransformer {


    public static CartResDto CartToCartResDto(Cart cart){

         List<ItemResDto> itemResDtoList = new ArrayList<>();

         for(Item item: cart.getItemList()){

              ItemResDto itemResDto  = ItemTransformer.ItemToItemResDto(item);

              itemResDtoList.add(itemResDto);
         }


         return CartResDto.builder()
                 .cartToatal(cart.getCartTotal())
                 .customerName(cart.getCustomer().getName())
                 .itemResDtoList(itemResDtoList)
                 .build();
    }
}
