package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository) {
		return args -> {

			customerRepository.save(Customer.builder().name("Customer 1").email("cust1@gmail.com").build());
			customerRepository.save(Customer.builder().name("Customer 2").email("hhjjh@gmail.com").build());
			customerRepository.save(Customer.builder().name("Customer 3").email("hkjdfjkf@hotmail.com").build());

		};
	}

}
