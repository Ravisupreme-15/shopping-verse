package com.example.shoppingverse.dto.resDto;

import com.example.shoppingverse.Enum.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CardResDto {


       String customerName;

       // masked cardNo
       String cardNo;

       Date validTill;

       CardType cardType;


}
