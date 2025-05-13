package com.preptrain.banking_app_springboot.repository;

import com.preptrain.banking_app_springboot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
