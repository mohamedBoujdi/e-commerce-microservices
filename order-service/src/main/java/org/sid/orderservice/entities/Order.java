package org.sid.orderservice.entities;

import lombok.*;
import org.sid.orderservice.enums.OrderStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders") //to avoid conflict with the keyword "order" in SQL
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date orderDate;
    private OrderStatus orderStatus;
    private Long customerId;//as a foreign key to the customer table
    private double totalPrice;
    @OneToMany(mappedBy = "orderDetails")
    private List<ProductItem> productItems;
    @Transient
    private Customer customer;


}
