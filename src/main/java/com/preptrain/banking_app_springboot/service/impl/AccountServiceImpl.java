package com.preptrain.banking_app_springboot.service.impl;

import com.preptrain.banking_app_springboot.dto.AccountDto;
import com.preptrain.banking_app_springboot.entity.Account;
import com.preptrain.banking_app_springboot.mapper.AccountMapper;
import com.preptrain.banking_app_springboot.repository.AccountRepository;
import com.preptrain.banking_app_springboot.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(final AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        final Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
