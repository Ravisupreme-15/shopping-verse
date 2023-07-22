package com.example.shoppingverse.dto.resDto;

import com.example.shoppingverse.Enum.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CardResDto {

    // masked cardNo ::---  ex: xxxxxxxxxxxx1234
    String  cardNo;

    String customerName;

    Date validDate;

    CardType cardType;

}
