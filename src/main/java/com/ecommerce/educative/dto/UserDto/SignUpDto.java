package com.ecommerce.educative.dto.UserDto;

import java.util.List;

import com.ecommerce.educative.model.Role;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignUpDto {
    // private Long id;
    private String username;
    private String email;
    private String password;
    private List<Role> roles;

    public SignUpDto( String username, String email, String password) {
        // this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public SignUpDto(String username, String email, String password, List<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        roles.forEach(role -> this.roles.add(new Role(role)));
    }
}
