package org.sid.inventoryservice.repositories;

import org.sid.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource //to expose the repository as a REST service

public interface ProductRepository extends JpaRepository<Product, Long> {
}
