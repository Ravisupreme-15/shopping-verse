package com.example.shoppingverse.exception;

public class InsufficientQuantityException extends RuntimeException {
    public InsufficientQuantityException(String insufficientQuantityOfItem) {

            super(insufficientQuantityOfItem);
    }
}
