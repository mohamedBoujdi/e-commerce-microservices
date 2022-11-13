package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication//= @Configuration (is a source of bean definitions for the application context)
// + @EnableAutoConfiguration + @ComponentScan(is to scan the current package)
@EnableDiscoveryClient//optional
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
  @Bean
	CommandLineRunner start(ProductRepository productRepository) {
		return args -> {
			productRepository.save(Product.builder().name("Product 1").price(1000).quantity(10).build());
			productRepository.save(Product.builder().name("Product 2").price(2000).quantity(20).build());
			productRepository.save(Product.builder().name("Product 3").price(3000).quantity(30).build());
			productRepository.save(Product.builder().name("Product 4").price(4000).quantity(40).build());
			productRepository.save(Product.builder().name("Product 5").price(5000).quantity(50).build());
		};
	}

}
