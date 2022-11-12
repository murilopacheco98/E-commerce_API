package com.ecommerce.educative.model;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "adress")
    private String adress;

    @Column(name = "status")
    @Value("${status:pending}")
    private String status;
}
