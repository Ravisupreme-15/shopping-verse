package com.example.shoppingverse.dto.resDto;

import jakarta.annotation.Nonnull;
import jakarta.annotation.security.DenyAll;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class OrderResDto {


    String OrderId;

    Date orderDate;

    String cardUsed;

    int orderTotal;

    String customerName;

    List<ItemResDto> itemResDtoList;
}
