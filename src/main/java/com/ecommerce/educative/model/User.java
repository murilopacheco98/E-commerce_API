package com.ecommerce.educative.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable( 
        name = "users_roles", 
        joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")}, 
        inverseJoinColumns =
            @JoinColumn(name = "role_id", referencedColumnName = "id")
        ) 
    private Set<Role> roles = new HashSet<>();

    private String authenticationToken;

    public User(String username, String email, String encryptedPassword) {
        this.username = username;
        this.email = email;
        this.password = encryptedPassword;
        this.createdAt = LocalDateTime.now();
    }

    public User(String username, String email, String encryptedPassword, Set<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = encryptedPassword;
        this.createdAt = LocalDateTime.now();
        this.roles = roles;
    }
}
