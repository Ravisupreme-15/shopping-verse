package com.example.shoppingverse.dto.resDto;

import com.example.shoppingverse.Enum.PrdCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ItemResDto {

    String itemName;

    int itemPrice;

    int quantityAdded;

    PrdCategory prdCategory;
}
