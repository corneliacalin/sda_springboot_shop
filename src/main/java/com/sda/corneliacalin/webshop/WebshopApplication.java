package com.sda.corneliacalin.webshop;

import com.sda.corneliacalin.webshop.model.Account;
import com.sda.corneliacalin.webshop.service.CustomerService;
import com.sda.corneliacalin.webshop.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class WebshopApplication implements CommandLineRunner {   // pt rulare linie comanda

    @Autowired
    private CustomerService customerService;	// autoinjectare

    @Autowired
    private MailService mailService;

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
		customerService.addCustomer(account1);

		customerService.getCustomerAccount().forEach(System.out::println);

    mailService.sendMail("corneliacalin@yahoo.com","calincornelia@gmail.com", "test1",
            "acesta este corpul mailului");

    }
}
