package com.example.shoppingverse.dto.reqDto;

import com.example.shoppingverse.Enum.CardType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CardReqDto {


    //customer emailid
    String mobileNo;

    String cardNo;

    int cvv;

    CardType cardType;

    Date validTill;

}
