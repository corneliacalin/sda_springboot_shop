package com.sda.corneliacalin.webshop.repository;

import com.sda.corneliacalin.webshop.model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepository {

    private List<Account> accounts = new ArrayList<>();

    public List<Account> getAll (){
        return accounts;
    }
    public void save (Account account){
        accounts.add(account);
    }


}