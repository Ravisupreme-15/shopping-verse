package com.example.shoppingverse.dto.reqDto;

import com.example.shoppingverse.Enum.PrdStatus;
import com.example.shoppingverse.Enum.prdCategory;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jdk.jfr.Name;
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

    prdCategory category;

    // seller emailid
    String emailId;

}
