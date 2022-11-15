package com.ecommerce.educative.service.user;

import com.ecommerce.educative.exception.customExceptions.AutheticationFailExeception;
import com.ecommerce.educative.model.user.AuthenticationToken;
import com.ecommerce.educative.model.user.UserEntity;
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

    public AuthenticationToken getToken(UserEntity userEntity) {
        return tokenRepository.findByUserEntity(userEntity);
    }

    public UserEntity getUserEntity(String token) {
        AuthenticationToken authenticationToken = tokenRepository.findByToken(token);
        if (Objects.isNull(token)) {
            return null;
        }
        return authenticationToken.getUserEntity();
    }

    public void authenticate(String token) {
        if (Objects.isNull(token)) {
            throw new AutheticationFailExeception("token not present");
        }

        if (Objects.isNull(getUserEntity(token))) {
            throw new AutheticationFailExeception("token not valid");
        }
    }
}
