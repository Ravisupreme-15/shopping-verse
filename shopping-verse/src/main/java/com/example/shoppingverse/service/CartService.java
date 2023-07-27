package com.example.shoppingverse.service;


import com.example.shoppingverse.dto.reqDto.ItemReqDto;
import com.example.shoppingverse.dto.resDto.CartResDto;
import com.example.shoppingverse.model.Cart;
import com.example.shoppingverse.model.Customer;
import com.example.shoppingverse.model.Item;
import com.example.shoppingverse.model.Product;
import com.example.shoppingverse.repository.CartRepository;
import com.example.shoppingverse.repository.CustomerRepository;
import com.example.shoppingverse.repository.ItemRepository;
import com.example.shoppingverse.repository.ProductRepository;
import com.example.shoppingverse.transformer.CartTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.awt.*;

@Service
public class CartService {


    @Autowired
    CustomerRepository customerRepository;


    @Autowired
    ItemRepository itemRepository;


    @Autowired
    CartRepository cartRepository;




    @Autowired
    ProductRepository productRepository;


    public CartResDto addItemToCart(ItemReqDto itemReqDto, Item item) {



         // get the customer


        Customer customer  = customerRepository.findByEmailId(itemReqDto.getEmailId());

        Product product = item.getProduct();

        Cart cart = customer.getCart();
        int newcartTotal = cart.getCartTotal()+(item.getRequiredQty()*product.getPrice());
        cart.setCartTotal(newcartTotal);

        item.setCart(cart);
        Item savedItem = itemRepository.save(item);
        cart.getItemList().add(savedItem);

        product.getItemList().add(savedItem);


        Cart savedCart  = cartRepository.save(cart);
        Product savedProduct = productRepository.save(product);

        // create cart res dto

        CartResDto cartResDto  = CartTransformer.CartToCartResDto(savedCart);

        return cartResDto;
    }
}
