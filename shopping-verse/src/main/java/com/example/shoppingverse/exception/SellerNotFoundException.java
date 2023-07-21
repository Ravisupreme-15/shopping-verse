package com.example.shoppingverse.exception;

public class SellerNotFoundException extends RuntimeException {
    public SellerNotFoundException(String inavliSellerEmailId) {

        super(inavliSellerEmailId);
    }
}
