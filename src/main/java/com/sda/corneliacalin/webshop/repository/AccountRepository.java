package com.sda.corneliacalin.webshop.repository;

import com.sda.corneliacalin.webshop.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;


public interface AccountRepository extends CrudRepository<Account,Long> {

    List<Account> findAllByIsClosed(Boolean isClosed);

    List<Account> findAllBybillingAddress(String billingAddress);

    List<Account> findAllByCreationDateBetween(Date startDate, Date endDate);

    List<Account> findAllByBillingAddressStartingWith(String city);

}
