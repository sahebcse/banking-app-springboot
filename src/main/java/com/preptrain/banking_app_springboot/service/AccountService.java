package com.preptrain.banking_app_springboot.service;

import com.preptrain.banking_app_springboot.dto.AccountDto;
import com.preptrain.banking_app_springboot.entity.Account;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto depositAmount(Long id, double amount);

    AccountDto withdrawAmount(Long id, double amount);

    List<AccountDto> getAllAccounts();

    AccountDto deleteAccount(Long id);
}
