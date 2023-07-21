package com.example.shoppingverse.dto.reqDto;

import com.example.shoppingverse.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerReqDto {

    String name;
    String email;

    String mobleNo;

    Gender gender;

}
