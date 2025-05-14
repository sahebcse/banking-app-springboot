package com.preptrain.banking_app_springboot.mapper;

import com.preptrain.banking_app_springboot.dto.AccountDto;
import com.preptrain.banking_app_springboot.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto) {
        Account account = new Account();
        account.setId(accountDto.id());
        account.setAccountHolderName(accountDto.accountHolderName());
        account.setBalance(accountDto.balance());
        return account;
    }

    public static AccountDto mapToAccountDto(Account account) {
        return new AccountDto(account.getId(),
                account.getAccountHolderName(),
                account.getBalance());
    }
}
