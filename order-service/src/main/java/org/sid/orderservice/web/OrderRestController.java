package org.sid.orderservice.web;

import lombok.AllArgsConstructor;
import org.sid.orderservice.entities.Order;
import org.sid.orderservice.repositories.OrderRepository;
import org.sid.orderservice.repositories.ProductItemRepository;
import org.sid.orderservice.service.CustomerRestClientService;
import org.sid.orderservice.service.InventoryRestClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class OrderRestController {
    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;

    private CustomerRestClientService customerRestClientService;
    private InventoryRestClientService inventoryRestClientService;
  @GetMapping("/fullOrders/{id}")
    public Order getOrder(@PathVariable Long id) {
        Order order= orderRepository.findById(id).get();
        order.setCustomer(customerRestClientService.getCustomerById(order.getCustomerId()));
        order.getProductItems().forEach(pi->{
            pi.setProduct(inventoryRestClientService.getProductById(pi.getProductId()));
        });
    return order;
    }


}
