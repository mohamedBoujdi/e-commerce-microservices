package org.sid.orderservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.ref.Reference;

@Entity(name = "product_items")
@NoArgsConstructor @AllArgsConstructor
@Data @Builder
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private double price;
    private int quantityOrdered;
    private Long productId;
    @ManyToOne
    private Order orderDetails;
    private  double discount;
    @Transient
    private Product product;

}
