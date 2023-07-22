package com.example.shoppingverse.dto.reqDto;

import com.example.shoppingverse.model.Cart;
import com.example.shoppingverse.model.Product;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ItemReqDto {

    int requiredQty;

    String emailId;

    int prdId;
}
