package com.ecommerce.educative.security;

import org.springframework.stereotype.Service;

import com.ecommerce.educative.exception.customExceptions.NotFoundException;
import com.ecommerce.educative.model.user.UserEntity;
import com.ecommerce.educative.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws NotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        return new User(user.getEmail(), user.getPassword(), user.isEnabled(), true, true,
                true, user.getAuthorities());
    }

    // private Collection<GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) {
    //     return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    // }
}
