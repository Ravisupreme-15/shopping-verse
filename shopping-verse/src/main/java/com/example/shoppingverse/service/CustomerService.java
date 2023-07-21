package com.example.shoppingverse.service;


import com.example.shoppingverse.dto.reqDto.CustomerReqDto;
import com.example.shoppingverse.dto.resDto.CustomerResDto;
import com.example.shoppingverse.model.Cart;
import com.example.shoppingverse.model.Customer;
import com.example.shoppingverse.repository.CustomerRepository;
import com.example.shoppingverse.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

   @Autowired
   CustomerRepository customerRepository;
    public CustomerResDto addNewCustomer(CustomerReqDto customerReqDto) {


            // dto - entity

        Customer customer = CustomerTransformer.CustomerReqToEntity(customerReqDto);


          Cart cart = new Cart();
          cart.setCustomer(customer);
          cart.setCartTotal(0);

          customer.setCart(cart);



          Customer savedCustomer = customerRepository.save(customer);


          // entity - resdto

        CustomerResDto customerResDto = CustomerTransformer.CustomerEntityToResDto(savedCustomer);

        return customerResDto;

    }
}
