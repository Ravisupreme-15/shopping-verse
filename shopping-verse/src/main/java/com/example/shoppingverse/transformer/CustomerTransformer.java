package com.example.shoppingverse.transformer;

import com.example.shoppingverse.dto.reqDto.CustomerReqDto;
import com.example.shoppingverse.dto.resDto.CustomerResDto;
import com.example.shoppingverse.model.Customer;
import lombok.experimental.UtilityClass;


// @UtilityClass ==> for ensure to restrice create the instance of the class
public class CustomerTransformer {


    public static Customer CustomerReqToEntity(CustomerReqDto customerReqDto){


           return  Customer.builder()
                   .name(customerReqDto.getName())
                   .mobileNo(customerReqDto.getMobleNo())
                   .gender(customerReqDto.getGender())
                   .emailId(customerReqDto.getEmail())
                   .build();

    }

    public static CustomerResDto CustomerEntityToResDto(Customer customer){

        return CustomerResDto.builder()
                .name(customer.getName())
                .email(customer.getEmailId())
                .mobleNo(customer.getMobileNo())
                .gender(customer.getGender())
                .build();


    }
}
