package com.preptrain.banking_app_springboot.service.impl;

import com.preptrain.banking_app_springboot.dto.AccountDto;
import com.preptrain.banking_app_springboot.dto.TransferAccountDto;
import com.preptrain.banking_app_springboot.entity.Account;
import com.preptrain.banking_app_springboot.exception.AccountException;
import com.preptrain.banking_app_springboot.exception.InsufficientBalanceException;
import com.preptrain.banking_app_springboot.mapper.AccountMapper;
import com.preptrain.banking_app_springboot.repository.AccountRepository;
import com.preptrain.banking_app_springboot.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public AccountDto getAccountById(final Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()->
                new AccountException("Account not found with id: " + id));

        return AccountMapper.mapToAccountDto(account);

    }

    @Override
    public AccountDto depositAmount(final Long id, final double amount) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setBalance(account.getBalance() + amount);
            Account updatedAccount = accountRepository.save(account);
            return AccountMapper.mapToAccountDto(updatedAccount);
        } else {
            throw new AccountException("Account not found with id: " + id);
        }
    }

    @Override
    public AccountDto withdrawAmount(final Long id, final double amount) {

        //withdraw amount using account repository
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                Account updatedAccount = accountRepository.save(account);
                return AccountMapper.mapToAccountDto(updatedAccount);
            } else {
                throw new RuntimeException("Insufficient balance in account with id: " + id);
            }
        } else {
            throw new AccountException("Account not found with id: " + id);
        }
    }

    @Override
    public List<AccountDto> getAllAccounts() {

        //return all account using account repository
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map(AccountMapper::mapToAccountDto)
                .toList();
    }

    @Override
    public AccountDto deleteAccount(final Long id) {

        //delete account using account repository
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            accountRepository.delete(optionalAccount.get());
            return AccountMapper.mapToAccountDto(optionalAccount.get());
        } else {
            throw new AccountException("Account not found with id: " + id);
        }
    }

    @Override
    public void transferAmount(final TransferAccountDto transferAccountDto) {

//find by id else throw
        Account fromAccount = accountRepository.findById(transferAccountDto.fromAccountId()).orElseThrow(()->
                new AccountException("Account not found with id: " + transferAccountDto.fromAccountId()));
        Account toAccount = accountRepository.findById(transferAccountDto.toAccountId()).orElseThrow(()->
                new AccountException("Account not found with id: " + transferAccountDto.toAccountId()));

        //check if balance is sufficient
        if (fromAccount.getBalance() >= transferAccountDto.amount()) {
            fromAccount.setBalance(fromAccount.getBalance() - transferAccountDto.amount());
            toAccount.setBalance(toAccount.getBalance() + transferAccountDto.amount());
            accountRepository.save(fromAccount);
            accountRepository.save(toAccount);
        } else {
            throw new InsufficientBalanceException("Insufficient balance in account with id: " + transferAccountDto.fromAccountId());
        }
    }


}
