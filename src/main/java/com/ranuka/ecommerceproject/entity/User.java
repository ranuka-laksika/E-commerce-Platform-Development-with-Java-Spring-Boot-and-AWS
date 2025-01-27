package com.ranuka.ecommerceproject.entity;

import com.ranuka.ecommerceproject.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is required")
    private String userName;

    @Column(unique=true)
    @NotBlank(message="Email is required")
    private String email;

    @NotBlank(message="Password is required")
    private String password;

    @Column(name="phone_number")
    @NotBlank(message="Phone number is required")
    private String phoneNUmber;

    private UserRole role;

    @OneToMany(mappedBy = "user",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    private List<OrderItem> orderItemList;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Address address;

    @Column(name="created_at")
    private final LocalDateTime createdAt = LocalDateTime.now();


}
