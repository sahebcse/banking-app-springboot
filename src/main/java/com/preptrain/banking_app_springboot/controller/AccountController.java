package com.preptrain.banking_app_springboot.controller;

import com.preptrain.banking_app_springboot.dto.AccountDto;
import com.preptrain.banking_app_springboot.entity.Account;
import com.preptrain.banking_app_springboot.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(final AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        AccountDto createdAccount = accountService.createAccount(accountDto);
        return ResponseEntity.ok(createdAccount);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> depositAmount(@PathVariable Long id, @RequestBody Map<String, Double> requestBody) {
        double amount = requestBody.get("amount");
        AccountDto updatedAccount = accountService.depositAmount(id, amount);
        return ResponseEntity.ok(updatedAccount);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdrawAmount(@PathVariable Long id, @RequestBody Map<String, Double> requestBody) {
        double amount = requestBody.get("amount");
        AccountDto updatedAccount = accountService.withdrawAmount(id, amount);
        return ResponseEntity.ok(updatedAccount);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<AccountDto> deleteAccount(@PathVariable Long id) {
        AccountDto deletedAccount = accountService.deleteAccount(id);
        return ResponseEntity.ok(deletedAccount);
    }

}
