package com.ecommerce.educative.repository;

import com.ecommerce.educative.model.cart.WishList;
import com.ecommerce.educative.model.user.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {
    List<WishList> findAllByUserEntityOrderByCreatedAtDesc(UserEntity userEntity);
}
