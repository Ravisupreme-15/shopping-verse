package com.example.shoppingverse.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String s) {

        super(s);
    }
}
