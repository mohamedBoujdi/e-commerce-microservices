package org.sid.customerservice.repositories;

import org.sid.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
// This annotation is used to expose the repository as a REST service
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
