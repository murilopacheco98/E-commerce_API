package com.ecommerce.educative.model.product;

import com.ecommerce.educative.dto.ProductDto;
import com.ecommerce.educative.model.cart.Cart;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private @NotBlank String title;

    @Column(name = "img")
    private @NotBlank String img;

    @Column(name = "price")
    private @NotBlank double price;

    @Column(name = "description")
    private @NotBlank String description;

    @Column(name = "size")
    private String size;

    @Column(name = "color")
    private String color;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    Category category;

//    @JsonIgnore
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
//    private List<WishList> wishListList;

   @JsonIgnore
   @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
   private List<Cart> carts;

    public Product(ProductDto productDto, Category category) {
        this.title = productDto.getTitle();
        this.img = productDto.getImg();
        this.description = productDto.getDescription();
        this.price = productDto.getPrice();
        this.category = category;
    }
    
}
