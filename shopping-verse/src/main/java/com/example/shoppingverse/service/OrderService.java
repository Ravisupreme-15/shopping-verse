package com.example.shoppingverse.service;


import com.example.shoppingverse.Enum.PrdStatus;
import com.example.shoppingverse.dto.reqDto.CartReqDto;
import com.example.shoppingverse.dto.reqDto.OrderReqDto;
import com.example.shoppingverse.dto.resDto.OrderResDto;
import com.example.shoppingverse.exception.CustomerNotFoundException;
import com.example.shoppingverse.exception.InsufficientQuantityException;
import com.example.shoppingverse.exception.InvalidCardException;
import com.example.shoppingverse.exception.ProductNotFoundException;
import com.example.shoppingverse.model.*;
import com.example.shoppingverse.repository.*;
import com.example.shoppingverse.transformer.CardTransformer;
import com.example.shoppingverse.transformer.ItemTransformer;
import com.example.shoppingverse.transformer.OrderTransformer;
import com.fasterxml.jackson.databind.DatabindException;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

      // customer repo

    @Autowired
    CustomerRepository customerRepository;


    @Autowired
    ProductRepository productRepository;


    @Autowired
    CardRepository cardRepository;


    @Autowired
    OrderRepository orderRepository;


    @Autowired
    ItemRepository itemRepository;


    public OrderResDto placeOrder(OrderReqDto orderReqDto) {


        // check for custome

        Customer customer = customerRepository.findByEmailId(orderReqDto.getCustomerEmail());


        if(customer==null){
            throw new CustomerNotFoundException("Customer not found");
        }


        Optional<Product> optionalProduct = productRepository.findById(orderReqDto. getProductId());

        if(optionalProduct.isEmpty()){

             throw new ProductNotFoundException("Sorry! invalid product Id");
        }


        Product product = optionalProduct.get();


        if(product.getAvailableQty()< orderReqDto.getRequiredQty()){

            throw new InsufficientQuantityException("Insufficient Quantity available");
        }


        Card card =  cardRepository.findByCardNo(orderReqDto.getCardUsed());

        Date today = new Date();
        if(card==null || card.getCvv()!=orderReqDto.getCvv() || today.after(card.getValidTill())){

            throw new InvalidCardException("Invalid Card Details");
        }

        int newqty = product.getAvailableQty()- orderReqDto.getRequiredQty();

        product.setAvailableQty(newqty);


        if(newqty==0){
            product.setStatus(PrdStatus.OUT_OF_STOCK);
        }


        // create order ettity

        OrderEntity order = new OrderEntity();

        order.setOrderId(String.valueOf(UUID.randomUUID()));
        order.setCardUsed(CardTransformer.getMaskedCardNo(card.getCardNo()));
        order.setOrderTotal(orderReqDto.getRequiredQty()*product.getPrice());


        Item item = ItemTransformer.ItemReqDtoToItem(orderReqDto.getRequiredQty());

        item.setOrderEntity(order);
        item.setProduct(product);

        order.getItemList().add(item);
        order.setCustomer(customer);


        OrderEntity savedOrder =orderRepository.save(order);


        product.getItemList().add(savedOrder.getItemList().get(0));
        customer.getOrderEntities().add(savedOrder);


        return OrderTransformer.OrderToOrderResDto(savedOrder);


    }

    public OrderEntity placeOrder(Cart cart, Card card) {


         List<Item> itemList = cart.getItemList();


         OrderEntity order = new OrderEntity();

         order.setOrderId(String.valueOf(UUID.randomUUID()));

         order.setCardUsed(CardTransformer.getMaskedCardNo(card.getCardNo()));


         int orderTotal=0;

         for(Item item: itemList){

             Product product = item.getProduct();

             if(product.getAvailableQty()< item.getRequiredQty()){

                 throw new InsufficientQuantityException("Sorry! Insufficient quantity available for the item "+product.getProductName());

             }

              int newqty = product.getAvailableQty() - item.getRequiredQty();


             product.setAvailableQty(newqty);

             if(newqty==0) product.setStatus(PrdStatus.OUT_OF_STOCK);


             orderTotal +=product.getPrice()*item.getRequiredQty();

             item.setOrderEntity(order);
         }
         order.setOrderTotal(orderTotal);
         order.setItemList(cart.getItemList());
         order.setCustomer(cart.getCustomer());



         return order;








    }
}
