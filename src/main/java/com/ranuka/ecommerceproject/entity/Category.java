package com.ranuka.ecommerceproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column(unique=true)
    private String name;

    private List<Product> productList;

    @Column(name="created_at")
    private final LocalDateTime createdAt= LocalDateTime.now();
}
