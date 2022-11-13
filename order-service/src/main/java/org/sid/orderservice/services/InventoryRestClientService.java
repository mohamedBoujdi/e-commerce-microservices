package org.sid.orderservice.services;

import org.sid.orderservice.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.logging.Logger;


@FeignClient(name = "inventory-service")
public interface InventoryRestClientService {
    Logger logger = Logger.getLogger(InventoryRestClientService.class.getName());
    @GetMapping("/products/{id}?projection=fullProduct")
    public Product getProductById(@PathVariable("id") Long productId);
    @GetMapping("/products?projection=fullProduct")
    public PagedModel<Product> getPagedProducts();
    //PageModel is a class from spring data rest that contains a list of products and some metadata
    //like the total number of products and the total number of pages
}
