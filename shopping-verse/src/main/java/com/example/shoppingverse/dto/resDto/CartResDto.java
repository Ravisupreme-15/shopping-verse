package com.example.shoppingverse.dto.resDto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CartResDto {

    String customerName;

    int cartToatal;


   List<ItemResDto> itemResDtoList;

}
