package org.sid.orderservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //to avoid infinite loop when serializing/deserializing
    //WRITE_ONLY: the property is only written during serialization(when sending data to the client)
    //READ_ONLY: the property is only read during deserialization (when receiving data from the client)
    @ManyToOne
    private Order orderDetails;
    private  double discount;
    @Transient
    private Product product;

}
