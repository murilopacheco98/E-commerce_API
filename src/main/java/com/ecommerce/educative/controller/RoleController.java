package com.ecommerce.educative.controller;

import com.ecommerce.educative.common.ApiResponse;
import com.ecommerce.educative.model.Role;
import com.ecommerce.educative.service.RoleService;
import com.ecommerce.educative.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/role")
@RestController
public class RoleController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public ResponseEntity<?> listRoles() {
      return new ResponseEntity<>(roleService.listRole(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> role(@RequestBody String name) {
        roleService.createRole(name);
        return new ResponseEntity<>(new ApiResponse(true, "Role created"), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRole(@RequestBody long id) {
        roleService.deleteRole(id);
        return new ResponseEntity<>(new ApiResponse(true, "Role deleted"), HttpStatus.NO_CONTENT);
    }

}
