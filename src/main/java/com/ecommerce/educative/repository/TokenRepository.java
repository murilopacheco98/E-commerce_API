package com.ecommerce.educative.repository;

import com.ecommerce.educative.model.user.AuthenticationToken;
import com.ecommerce.educative.model.user.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findByToken(String token);
    AuthenticationToken findByUserEntity(UserEntity userEntity);
}
