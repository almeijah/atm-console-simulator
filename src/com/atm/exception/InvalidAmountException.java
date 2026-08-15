package com.atm.exception;

public class InvalidAmountException extends RuntimeException{
    public InvalidAmountException (String message){
        super(message);
    }
}
//Create exception rules for insufficient deposits and withdrawals.
