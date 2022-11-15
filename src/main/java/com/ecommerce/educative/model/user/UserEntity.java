package com.ecommerce.educative.model.user;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity implements UserDetails {

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

    public UserEntity(String username, String email, String encryptedPassword) {
        this.username = username;
        this.email = email;
        this.password = encryptedPassword;
        this.createdAt = LocalDateTime.now();
    }

    public UserEntity(String username, String email, String encryptedPassword, Set<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = encryptedPassword;
        this.createdAt = LocalDateTime.now();
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Role role : this.roles) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
            authorities.add(authority);
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
