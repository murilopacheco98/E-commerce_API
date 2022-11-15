package com.ecommerce.educative.dto.UserDto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignUpDto {
    // private Long id;
    private String username;
    private String email;
    private String password;
    private List<Long> rolesId;

    public SignUpDto( String username, String email, String password) {
        // this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public SignUpDto(String username, String email, String password, List<Long> rolesId) {
        this.username = username;
        this.email = email;
        this.password = password;
        rolesId.forEach(role -> this.rolesId.add(role));
    }
}
