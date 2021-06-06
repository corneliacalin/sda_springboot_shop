package com.sda.corneliacalin.webshop;

import com.sda.corneliacalin.webshop.model.Account;
import com.sda.corneliacalin.webshop.model.Customer;
import com.sda.corneliacalin.webshop.repository.AccountRepository;
import com.sda.corneliacalin.webshop.service.CustomerService;
import com.sda.corneliacalin.webshop.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement  // activeaza partea de tranzactii

@EnableJpaRepositories(basePackages = "com.sda.corneliacalin.webshop.repository")
@EntityScan(basePackages = "com.sda.corneliacalin.webshop.model")

public class WebshopApplication implements CommandLineRunner {   // pt rulare linie comanda

    @Autowired
    private CustomerService customerService;	// autoinjectare

    @Autowired
    private MailService mailService;

    @Autowired
    private AccountRepository accountRepository;

    public static void main(String[] args) {

        SpringApplication.run(WebshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.refresh();
        // here start our code
		Account account1 = new Account();
		account1.setId(1L);

        Customer customer = new Customer();
        customer.setId(1L);
  customerService.addCustomer(account1,customer);

		customerService.getCustomerAccount().forEach(System.out::println);

    mailService.sendMail("corneliacalin@yahoo.com","calincornelia@gmail.com", "test1",
            "acesta este corpul mailului");

    accountRepository.findAllByIsClosed(false).forEach(System.out::println);

    }
}
