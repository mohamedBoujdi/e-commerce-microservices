package org.sid.orderservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.orderservice.enums.OrderStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data@NoArgsConstructor@Builder@AllArgsConstructor
@Entity
@Table(name = "orders") //to avoid conflict with the keyword "order" in SQL
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date orderDate;
    private OrderStatus orderStatus;
    private Long customerId;//as a foreign key to the customer table
    private Long productId;//as a foreign key because we have a many-to-one relationship between Order and Product
    private double totalPrice;
    @OneToMany(mappedBy = "orderDetails")
    private List<ProductItem> productItems;
    @Transient
    private Customer customer;


    public Order(Date date, OrderStatus paid, Customer customer) {
        this.orderDate = date;
        this.orderStatus = paid;
        this.customer = customer;
        this.customerId = customer.getId();
    }
}
