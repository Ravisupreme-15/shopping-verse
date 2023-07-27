package com.example.shoppingverse.service;

import com.example.shoppingverse.dto.reqDto.ItemReqDto;
import com.example.shoppingverse.dto.reqDto.ProductReqDto;
import com.example.shoppingverse.exception.CustomerNotFoundException;
import com.example.shoppingverse.exception.InsufficientQuantityException;
import com.example.shoppingverse.exception.ProductNotFoundException;
import com.example.shoppingverse.model.Customer;
import com.example.shoppingverse.model.Item;
import com.example.shoppingverse.model.Product;
import com.example.shoppingverse.repository.CustomerRepository;
import com.example.shoppingverse.repository.ProductRepository;
import com.example.shoppingverse.transformer.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.PrinterAbortException;
import java.text.ParseException;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    public Item creatItem(ItemReqDto itemReqDto) {


        Customer customer = customerRepository.findByEmailId(itemReqDto.getEmailId());
        if(customer==null) {
            throw new CustomerNotFoundException("Invalid customer emaiId");
        }


        Optional<Product> optionalProduct = productRepository.findById(itemReqDto.getPrdId());

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product Doen't exist");
        }


        Product product = optionalProduct.get();


        // check for required Qty

        if(product.getAvailableQty()<itemReqDto.getRequiredQty()){

            throw new InsufficientQuantityException("Insufficient quantity of Item");
        }


        // create an item

           Item item = ItemTransformer.ItemReqDtoToItem(itemReqDto.getRequiredQty());
           item.setProduct(product);

            return item;
    }
}
