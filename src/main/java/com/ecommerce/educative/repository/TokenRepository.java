package com.ecommerce.educative.repository;

import com.ecommerce.educative.model.AuthenticationToken;
import com.ecommerce.educative.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findByUser(User user);
    AuthenticationToken findByToken(String token);
}
