package com.ranuka.ecommerceproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.ranuka.ecommerceproject.entity.Category;

@Data
@Entity
@Table(name="products")

public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String imageUrl;
    private BigDecimal price;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;
    @Column(name="created_at")
    private final LocalDateTime caretedAt= LocalDateTime.now();

}
