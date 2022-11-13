package org.sid.orderservice;

import org.sid.orderservice.entities.Customer;
import org.sid.orderservice.entities.Order;
import org.sid.orderservice.entities.Product;
import org.sid.orderservice.entities.ProductItem;
import org.sid.orderservice.enums.OrderStatus;
import org.sid.orderservice.repositories.OrderRepository;
import org.sid.orderservice.repositories.ProductItemRepository;
import org.sid.orderservice.services.CustomerRestClientService;
import org.sid.orderservice.services.InventoryRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner start(OrderRepository orderRepository,
							ProductItemRepository productItemRepository,
							CustomerRestClientService customerRestClientService,
							InventoryRestClientService productRestClientService) {


		return args -> {
			List<Customer> customers = customerRestClientService.getAllCustomers().getContent().stream().toList();
			//System.out.println("Customers: " + customers);
			List<Product> products = productRestClientService.getPagedProducts().getContent().stream().toList();
			//System.out.println("Products: " + products);//for debugging
		    // orders for customers
			Random random = new Random();
			//orders for each customer
			 for (int i = 0; i < 30; i++) {
				 int randomIndex = random.nextInt(customers.size());
				 Customer customer= (Customer) customers.get(randomIndex);
				// System.out.println("Customer "+i+": " + customer); //for debugging
				 Order order = Order.builder()
						 .customerId(customer.getId())
						 .orderStatus(Math.random() < 0.5 ? OrderStatus.PAID : OrderStatus.DELIVERED)
						 .orderDate(new Date())
						 .customer(customers.get(randomIndex))
						 .build();
				// System.out.println("Order saved: " + order);//for debugging
				 Order saved = orderRepository.save(order);
				 // product items for orders
				 for (Product product : products) {
					 if (Math.random() < 0.4) {
						 ProductItem productItem = ProductItem.builder()
								 .productId(product.getId())
								 .orderDetails(saved)
								 .product(product)
								 .quantityOrdered(1+random.nextInt(10))//1 to 10
								 .price(product.getPrice())
								 .build();
						 productItemRepository.save(productItem);
					 }
				 }
			 }
		};

	}
}
