package com.ecommerce.educative.dto;

import java.util.List;

import lombok.Data;

@Data
public class CreateUserRoleDto {
  private Long idUser;
  
  private List<Long> idsRoles;
}
