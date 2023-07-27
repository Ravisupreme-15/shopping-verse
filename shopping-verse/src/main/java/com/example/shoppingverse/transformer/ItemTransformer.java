package com.example.shoppingverse.transformer;

import com.example.shoppingverse.Enum.PrdCategory;
import com.example.shoppingverse.dto.reqDto.ItemReqDto;
import com.example.shoppingverse.dto.resDto.ItemResDto;
import com.example.shoppingverse.model.Item;
import jakarta.persistence.Id;

public class ItemTransformer {


    public static Item ItemReqDtoToItem(int requiredQty){


        return Item.builder()
                .requiredQty(requiredQty).build();
    }

    public  static  ItemResDto ItemToItemResDto(Item item){



        return  ItemResDto.builder()
                .itemName(item.getProduct().getProductName())
                .itemPrice(item.getProduct().getPrice())
                .quantityAdded(item.getRequiredQty())
                .prdCategory(item.getProduct().getCategory()).build();
    }
}
