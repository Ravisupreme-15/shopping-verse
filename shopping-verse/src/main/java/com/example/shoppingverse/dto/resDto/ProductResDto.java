package com.example.shoppingverse.dto.resDto;

import com.example.shoppingverse.Enum.PrdStatus;
import com.example.shoppingverse.Enum.PrdCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductResDto {

    String sellerName;

    int price;

    String productName;

    int availableQty;


    PrdCategory category;

    PrdStatus status;

}
