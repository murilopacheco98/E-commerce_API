package com.ecommerce.educative.controller;

import com.ecommerce.educative.dto.ResponseDto;
import com.ecommerce.educative.dto.UserDto.SignInDto;
import com.ecommerce.educative.dto.UserDto.SignInResponseDto;
import com.ecommerce.educative.dto.UserDto.SignUpDto;
import com.ecommerce.educative.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseDto signUp(@RequestBody SignUpDto signUpDto) {
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signin")
    public SignInResponseDto signIn(@RequestBody SignInDto signInDto) {
        return userService.signIn(signInDto);
    }
}
