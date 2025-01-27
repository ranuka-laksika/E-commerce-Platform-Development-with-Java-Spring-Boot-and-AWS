package com.ranuka.ecommerceproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private BigDecimal totalPrice;
    @OneToMany(mappedBy = "order" , fetch =FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderItem> orderItemlist;

    @Column


}
