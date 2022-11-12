package com.ecommerce.educative.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.educative.dto.CreateUserRoleDto;
import com.ecommerce.educative.model.Role;
import com.ecommerce.educative.model.User;
import com.ecommerce.educative.repository.UserRepository;

@Service
public class CreateRoleUserService {

  @Autowired
  UserRepository userRepository;

  public User execute(CreateUserRoleDto createUserRoleDTO) {

    Optional<User> userExists = userRepository.findById(createUserRoleDTO.getIdUser());
    Set<Role> roles = new HashSet<>();

    if (userExists.isEmpty()) {
      throw new Error("User does not exists!");
    }

    roles = createUserRoleDTO.getIdsRoles().stream().map(role -> {
      return new Role(role);
    }).collect(Collectors.toSet());

    User user = userExists.get();

    user.setRoles(roles);

    userRepository.save(user);

    return user;
  }

}