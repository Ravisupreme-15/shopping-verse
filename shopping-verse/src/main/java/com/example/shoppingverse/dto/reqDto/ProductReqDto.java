package com.example.shoppingverse.dto.reqDto;

import com.example.shoppingverse.Enum.PrdCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ProductReqDto {

    String productName;

    int price;

    int availableQty;

    PrdCategory category;

    // seller emailid
    String emailId;

}
