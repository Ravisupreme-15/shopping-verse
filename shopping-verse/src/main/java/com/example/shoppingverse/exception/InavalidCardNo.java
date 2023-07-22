package com.example.shoppingverse.exception;

public class InavalidCardNo extends RuntimeException {
    public InavalidCardNo(String cardNoLengthIsMisMatching) {

         super(cardNoLengthIsMisMatching);
    }
}
