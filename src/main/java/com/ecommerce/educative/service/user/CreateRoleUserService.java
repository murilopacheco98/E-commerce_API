// package com.ecommerce.educative.service.user;

// import java.util.HashSet;
// import java.util.Optional;
// import java.util.Set;
// import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.ecommerce.educative.dto.CreateUserRoleDto;
// import com.ecommerce.educative.exception.customExceptions.BadRequestException;
// import com.ecommerce.educative.model.user.Role;
// import com.ecommerce.educative.model.user.UserEntity;
// import com.ecommerce.educative.repository.UserRepository;

// @Service
// public class CreateRoleUserService {

//   @Autowired
//   UserRepository userRepository;

//   public UserEntity execute(CreateUserRoleDto createUserRoleDTO) {

//     Optional<UserEntity> userExists = userRepository.findById(createUserRoleDTO.getIdUser());
//     Set<Role> roles = new HashSet<>();

//     if (userExists.isEmpty()) {
//       throw new BadRequestException("UserEntity does not exists!");
//     }

//     roles = createUserRoleDTO.getIdsRoles().stream().map(role -> {
//       return new Role(role);
//     }).collect(Collectors.toSet());

//     UserEntity userEntity = userExists.get();

//     userEntity.setRoles(roles);

//     userRepository.save(userEntity);

//     return userEntity;
//   }
// }