package com.ecommerce.educative.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.educative.Exceptions.NotFoundException;
import com.ecommerce.educative.model.Role;
import com.ecommerce.educative.repository.RoleRepository;
import com.ecommerce.educative.repository.UserRepository;

@Service
public class RoleService {
  
  @Autowired
  RoleRepository roleRepository;
  
  @Autowired
  AuthenticationService authenticationService;
    
  @Autowired
  UserRepository userRepository;

  public Role createRole(String name) {
    Role role = new Role(name);
    List<Role> roles = roleRepository.findAll();
    if (roles.isEmpty()) {
      role.setId((long) 1);
    } else {
      role.setId(roles.get(roles.size() - 1).getId() + 1);
    }
    
    return roleRepository.save(role);
  }

  public List<Role> listRole() {
    return roleRepository.findAll();
  }

  public void deleteRole(Long id) {
    roleRepository.deleteById(id);
  }

  public void updateRole(long id, Role role) {
    Optional<Role> optionalRole = roleRepository.findById(id);

    if(optionalRole.isEmpty()) {
      throw new NotFoundException("Role not found");
    }
  }

  // public User changeUserRole(CreateUserRoleDto createUserRoleDTO) {

  //   Optional<User> userExists = userRepository.findById(createUserRoleDTO.getIdUser());
  //   List<Role> roles = new ArrayList<Role>();

  //   if (userExists.isEmpty()) {
  //     throw new Error("User does not exists!");
  //   }

  //   roles = createUserRoleDTO.getIdsRoles().stream().map(role -> {
  //     return new Role(role);
  //   }).collect(Collectors.toList());

  //   User user = userExists.get();
  //   user.setRoles(roles);
  //   userRepository.save(user);

  //   return user;
  // }
}
