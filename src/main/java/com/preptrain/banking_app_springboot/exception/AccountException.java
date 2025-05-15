package com.preptrain.banking_app_springboot.exception;

public class AccountException extends RuntimeException{

    public AccountException(String message) {
        super(message);
    }

}
