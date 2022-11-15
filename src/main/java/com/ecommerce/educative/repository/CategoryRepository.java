package com.ecommerce.educative.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.educative.model.product.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
