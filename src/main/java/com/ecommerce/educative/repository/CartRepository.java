package com.ecommerce.educative.repository;

import com.ecommerce.educative.model.cart.Cart;
import com.ecommerce.educative.model.user.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAllByUserEntityOrderByCreatedAt(UserEntity userEntity);
}
