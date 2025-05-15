package com.preptrain.banking_app_springboot.dto;

public record TransferAccountDto(Long fromAccountId,Long toAccountId, double amount) {

}
