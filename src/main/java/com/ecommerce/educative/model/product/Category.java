package com.ecommerce.educative.model.product;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "category_name")
    private @NotBlank String CategoryName;

    @Column(name= "description")
    private @NotBlank String Description;

    @Column(name = "image_url")
    private @NotBlank String imageUrl;
    
}
