package com.ecommerce.educative.model.cart;

import javax.persistence.*;

import com.ecommerce.educative.model.product.Product;
import com.ecommerce.educative.model.user.UserEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "wishlist")
public class WishList {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  private UserEntity userEntity;

  @Column(name = "created_at")
  private Date createdAt;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  public WishList(UserEntity userEntity, Product product) {
    this.userEntity = userEntity;
    this.product = product;
  }
}
