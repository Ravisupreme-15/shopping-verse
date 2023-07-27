package com.example.shoppingverse.dto.reqDto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderReqDto {

    String customerEmail;

    int  productId;

    String cardUsed;

    int cvv;

    int requiredQty;


}
