package com.example.shoppingverse.transformer;

import com.example.shoppingverse.dto.reqDto.ItemReqDto;
import com.example.shoppingverse.dto.resDto.ItemResDto;
import com.example.shoppingverse.model.Item;
import jakarta.persistence.Id;

public class ItemTransformer {


    public static Item ItemReqDtoToItem(int requiredQty){


        return Item.builder()
                .requiredQty(requiredQty).build();
    }
}
