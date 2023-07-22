package com.example.shoppingverse.service;


import com.example.shoppingverse.dto.reqDto.CardReqDto;
import com.example.shoppingverse.dto.resDto.CardResDto;
import com.example.shoppingverse.dto.resDto.CustomerResDto;
import com.example.shoppingverse.exception.CustomerNotFoundException;
import com.example.shoppingverse.exception.InavalidCardNo;
import com.example.shoppingverse.model.Card;
import com.example.shoppingverse.model.Customer;
import com.example.shoppingverse.repository.CardRepository;
import com.example.shoppingverse.repository.CustomerRepository;
import com.example.shoppingverse.transformer.CardTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired

    CardRepository cardRepository;

    @Autowired
    CustomerRepository customerRepository;

    public CardResDto addNewCard(CardReqDto cardReqDto) {


        Customer customer = customerRepository.findByMobileNo(cardReqDto.getMobileNo());

        if(customer==null){
            throw new CustomerNotFoundException("Invalid Customer mobileNo");
        }

        if((cardReqDto.getCardNo().length()<16) || (cardReqDto.getCardNo().length()>16))
            throw new InavalidCardNo("Check the cardNo length , mostly preferred 16digit length");

            // dto - entity // create new Card

            Card card = CardTransformer.CardReqDtoToEntity(cardReqDto);

            card.setCustomer(customer);

            customer.getCardList().add(card);

            Customer savedCustomer = customerRepository.save(customer);

            List<Card> cardList = savedCustomer.getCardList();

            Card latestCard = cardList.get(cardList.size() - 1);

            // entity - resdto  //  create resdto

            CardResDto cardResDto = CardTransformer.CardEntityToResDto(latestCard);


            return cardResDto;


    }
}