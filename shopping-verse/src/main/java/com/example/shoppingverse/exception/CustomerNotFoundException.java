package com.example.shoppingverse.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String invalidCustomerId) {

        super(invalidCustomerId);
    }
}
