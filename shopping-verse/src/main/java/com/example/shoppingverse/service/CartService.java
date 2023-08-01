package com.example.shoppingverse.service;


import com.example.shoppingverse.dto.reqDto.CartReqDto;
import com.example.shoppingverse.dto.reqDto.ItemReqDto;
import com.example.shoppingverse.dto.resDto.CartResDto;
import com.example.shoppingverse.dto.resDto.OrderResDto;
import com.example.shoppingverse.exception.CartIsEmpty;
import com.example.shoppingverse.exception.CustomerNotFoundException;
import com.example.shoppingverse.exception.InvalidCardException;
import com.example.shoppingverse.model.*;
import com.example.shoppingverse.repository.*;
import com.example.shoppingverse.transformer.CartTransformer;
import com.example.shoppingverse.transformer.OrderTransformer;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

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


    @Autowired
    CardRepository cardRepository;


    @Autowired
    OrderService orderService;


    @Autowired
    OrderRepository orderRepository;


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

    public OrderResDto checkoutCart(CartReqDto cartReqDto) {


        // check the customer
        Customer customer  = customerRepository.findByEmailId(cartReqDto.getEmailId());

        if(customer ==null) throw new CustomerNotFoundException("Invalid Customer emailId!");


        Card card = cardRepository.findByCardNo(cartReqDto.getCardNo());

        Date currDate = new Date();

        if(card==null || card.getCvv()!= cartReqDto.getCvv() || currDate.after(card.getValidTill()))
            throw new InvalidCardException("Invalid Card details!");




        Cart cart = customer.getCart();

        if(cart.getItemList().size()==0)
            throw new CartIsEmpty("Cart is empty");


        OrderEntity order = orderService.placeOrder(cart,card);

        resetCart(cart);

        OrderEntity savedOrder = orderRepository.save(order);

        // prepare response dto

        return OrderTransformer.OrderToOrderResDto(savedOrder);



    }

    public void resetCart(Cart cart){

        cart.setCartTotal(0);

        for(Item item: cart.getItemList()){
            item.setCart(null);
        }
        cart.setItemList(new ArrayList<>());


    }
}
