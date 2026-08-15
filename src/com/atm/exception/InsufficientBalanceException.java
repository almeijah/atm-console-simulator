package com.atm.exception;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException (String message){
        super  (message);
    }
}
//create rules of Exception for InsufficientBalance.