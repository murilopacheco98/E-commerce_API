package com.ecommerce.educative.repository;

import com.ecommerce.educative.model.User;
import com.ecommerce.educative.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {
    List<WishList> findAllByUserOrderByCreatedAtDesc(User user);
}
