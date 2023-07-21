package com.example.shoppingverse.dto.reqDto;

import com.example.shoppingverse.Enum.Gender;
import com.example.shoppingverse.dto.resDto.SellerResDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SellerReqDto {

    String name;

    String emailId;

    String panNo;

    String mobileNo;

    Gender gender;

}
