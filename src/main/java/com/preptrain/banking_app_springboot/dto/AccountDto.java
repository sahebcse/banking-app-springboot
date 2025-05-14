package com.preptrain.banking_app_springboot.dto;

import lombok.Data;

//@Data
//public class AccountDto {
//    private Long id;
//    private String accountHolderName;
//    private double balance;
//}

public record AccountDto(Long id, String accountHolderName, double balance) {
    public AccountDto {
        if (accountHolderName == null || accountHolderName.isBlank()) {
            throw new IllegalArgumentException("Account holder name cannot be null or blank");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
    }
}
