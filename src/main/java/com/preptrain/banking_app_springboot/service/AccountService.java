package com.preptrain.banking_app_springboot.service;

import com.preptrain.banking_app_springboot.dto.AccountDto;
import com.preptrain.banking_app_springboot.entity.Account;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
}
