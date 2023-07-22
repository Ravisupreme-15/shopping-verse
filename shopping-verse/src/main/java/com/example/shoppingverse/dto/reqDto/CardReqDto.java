package com.example.shoppingverse.dto.reqDto;

import com.example.shoppingverse.Enum.CardType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardReqDto {

    String mobileNo;

    String cardNo;

    int cvv;

    CardType cardType;


    Date validTill;
}
