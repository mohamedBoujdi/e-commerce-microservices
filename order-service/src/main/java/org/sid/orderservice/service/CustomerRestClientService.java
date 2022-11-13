package org.sid.orderservice.service;

import org.sid.orderservice.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "customer-service")
public interface CustomerRestClientService {
    // http://localhost:8081/customers/1?projection=fullCustomer
    @GetMapping("/customers/{id}?projection=fullCustomer")
    public Customer getCustomerById(@PathVariable("id") Long customerId);
    // http://localhost:8081/customers?projection=fullCustomer
    // (list of customers)
    @GetMapping("/customers?projection=fullCustomer")
    public PagedModel<Customer> getAllCustomers();
}
