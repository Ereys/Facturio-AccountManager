package com.facturio.demo.exceptions;

public class AccountAlreadyExistException extends Exception{

    public AccountAlreadyExistException(String message) {
        super(message);
    }
}
