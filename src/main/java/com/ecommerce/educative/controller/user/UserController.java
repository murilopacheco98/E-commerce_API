package com.ecommerce.educative.controller.user;

import com.ecommerce.educative.common.ApiResponse;
import com.ecommerce.educative.dto.UserDto.SignInDto;
import com.ecommerce.educative.dto.UserDto.SignUpDto;
import com.ecommerce.educative.model.user.UserEntity;
import com.ecommerce.educative.service.user.CreateRoleUserService;
import com.ecommerce.educative.service.user.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CreateRoleUserService createRoleUserService;

    @PostMapping("/register")
    public ResponseEntity<?> signUp(@RequestBody SignUpDto signUpDto) {
        // return userService.signUp(signUpDto);
        userService.signUp(signUpDto);
        return new ResponseEntity<>(new ApiResponse(true, "UserEntity created"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> signIn(@RequestBody SignInDto signInDto) {
        // return userService.signIn(signInDto);
        userService.signIn(signInDto);
        return new ResponseEntity<>(new ApiResponse(true, "Login success"), HttpStatus.OK);
    }

    @PreAuthorize("user")
    @GetMapping("/getAll")
    public ResponseEntity<List<UserEntity>> users() {
        List<UserEntity> users = userService.listUsers();
        return new ResponseEntity<List<UserEntity>>(users, HttpStatus.OK);
    }
}
