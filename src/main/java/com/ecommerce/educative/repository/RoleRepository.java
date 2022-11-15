package com.ecommerce.educative.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.educative.model.user.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

  Role findByName(String name);

}
