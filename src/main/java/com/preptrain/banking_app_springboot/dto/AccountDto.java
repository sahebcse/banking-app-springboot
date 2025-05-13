package com.preptrain.banking_app_springboot.dto;

import lombok.Data;

@Data
public class AccountDto {
    private Long id;
    private String accountHolderName;
    private double balance;
}
