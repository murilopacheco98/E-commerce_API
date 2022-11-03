package com.ecommerce.educative.service;

import com.ecommerce.educative.Exceptions.AutheticationFailExeception;
import com.ecommerce.educative.model.AuthenticationToken;
import com.ecommerce.educative.model.User;
import com.ecommerce.educative.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationService {
    @Autowired
    TokenRepository tokenRepository;

    public void saveConfirmationToken(AuthenticationToken authenticationToken) {
        tokenRepository.save(authenticationToken);
    }

    public AuthenticationToken getToken(User user) {
        return tokenRepository.findByUser(user);
    }

    public User getUser(String token) {
        AuthenticationToken authenticationToken = tokenRepository.findByToken(token);
        if (Objects.isNull(token)) {
            return null;
        }

        return authenticationToken.getUser();
    }

    public void authenticate(String token) {
        if (Objects.isNull(token)) {
            throw new AutheticationFailExeception("token not present");
        }

        if (Objects.isNull(getUser(token))) {
            throw new AutheticationFailExeception("token not valid");
        }
    }
}
