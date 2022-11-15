package com.ecommerce.educative.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.educative.model.product.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
