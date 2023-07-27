package com.example.shoppingverse.transformer;

import com.example.shoppingverse.dto.resDto.ItemResDto;
import com.example.shoppingverse.dto.resDto.OrderResDto;
import com.example.shoppingverse.model.Item;
import com.example.shoppingverse.model.OrderEntity;

import java.util.ArrayList;
import java.util.List;

public class OrderTransformer {


    public static OrderResDto OrderToOrderResDto(OrderEntity order){

        List<ItemResDto> list = new ArrayList<>();

        for(Item item : order.getItemList()){

             list.add(ItemTransformer.ItemToItemResDto(item));
        }

        return OrderResDto.builder()
                .orderTotal(order.getOrderTotal())
                .orderDate(order.getOrderDate())
                .customerName(order.getCustomer().getName())
                .OrderId(order.getOrderId())
                .cardUsed(order.getCardUsed())
                .itemResDtoList(list)
                .build();
    }
}
