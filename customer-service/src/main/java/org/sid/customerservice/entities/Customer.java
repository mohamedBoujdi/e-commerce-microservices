package org.sid.customerservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
/*@Table(name = "CUSTOMERS", schema = "CUSTOMER_SERVICE", catalog = "", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"ID"})
}, indexes = {
        @Index(name = "CUSTOMERS_PK", columnList = "ID", unique = true)
})*/
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "EMAIL")
    private String email;

}
