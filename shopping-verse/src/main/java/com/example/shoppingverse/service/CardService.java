package com.example.shoppingverse.service;


import com.example.shoppingverse.dto.reqDto.CardReqDto;
import com.example.shoppingverse.dto.resDto.CardResDto;
import com.example.shoppingverse.exception.CustomerNotFoundException;
import com.example.shoppingverse.model.Card;
import com.example.shoppingverse.model.Cart;
import com.example.shoppingverse.model.Customer;
import com.example.shoppingverse.repository.CustomerRepository;
import com.example.shoppingverse.transformer.CardTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

     @Autowired
    CustomerRepository customerRepository;

    public CardResDto addNewCard(CardReqDto cardReqDto) {


        Customer customer = customerRepository.findByMobileNo(cardReqDto.getMobileNo());

        if(customer==null) throw new CustomerNotFoundException("Customer mobileNo is invalid");


        // create card entity


        Card card = CardTransformer.CardReqDtoToEntity(cardReqDto);
        card.setCustomer(customer);

        customer.getCardList().add(card);

        Customer savedcustomer = customerRepository.save(customer);

        List<Card> cardList  = savedcustomer.getCardList();

        Card latestCard = cardList.get(cardList.size()-1);


        // make cardresdto
        CardResDto cardResDto = CardTransformer.CardEntityToResDto(latestCard);



        return cardResDto;


    }
}
