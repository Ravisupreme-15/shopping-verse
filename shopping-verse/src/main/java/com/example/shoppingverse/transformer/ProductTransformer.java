package com.example.shoppingverse.transformer;

import com.example.shoppingverse.Enum.PrdStatus;
import com.example.shoppingverse.dto.reqDto.ProductReqDto;
import com.example.shoppingverse.dto.resDto.ProductResDto;
import com.example.shoppingverse.model.Product;

public class ProductTransformer {


    public static Product ProductReqDtoToEntity(ProductReqDto productReqDto){



           return   Product.builder()
                   .productName(productReqDto.getProductName())
                   .price(productReqDto.getPrice())
                   .availableQty(productReqDto.getAvailableQty())
                   .category(productReqDto.getCategory())
                   .status(PrdStatus.AVAILABLE).build();
    }


    public static ProductResDto ProdctEntityToResDto(Product product){



        return    ProductResDto.builder()
                .sellerName(product.getSeller().getName())
                .productName(product.getProductName())
                .status(product.getStatus())
                .price(product.getPrice())
                .availableQty(product.getAvailableQty())
                .category(product.getCategory())
                .build();
    }
}
