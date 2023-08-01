package com.example.shoppingverse.exception;

public class CartIsEmpty extends RuntimeException {
    public CartIsEmpty(String cartIsEmpty) {

        super(cartIsEmpty);
    }
}
