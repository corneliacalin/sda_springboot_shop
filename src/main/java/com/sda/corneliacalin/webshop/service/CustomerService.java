package com.sda.corneliacalin.webshop.service;

import com.sda.corneliacalin.webshop.model.Account;
import com.sda.corneliacalin.webshop.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final AccountRepository accountRepository;

    // injected by spring by constructor
        public CustomerService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void addCustomer(Account account){
            accountRepository.save(account);

    }
    public List<Account> getCustomerAccount(){
            return accountRepository.getAll();
    }

}
