package com.ecommerce.educative.service;

import com.ecommerce.educative.Exceptions.AutheticationFailExeception;
import com.ecommerce.educative.Exceptions.CustomException;
import com.ecommerce.educative.dto.ResponseDto;
import com.ecommerce.educative.dto.UserDto.SignInDto;
import com.ecommerce.educative.dto.UserDto.SignInResponseDto;
import com.ecommerce.educative.dto.UserDto.SignUpDto;
import com.ecommerce.educative.model.AuthenticationToken;
import com.ecommerce.educative.model.User;
import com.ecommerce.educative.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;
    public ResponseDto signUp(SignUpDto signUpDto) {

        if (Objects.nonNull(userRepository.findByEmail(signUpDto.getEmail()))) {
            throw new CustomException("user already exist");
        }

        String encryptedPassword = signUpDto.getPassword();

        try {
            encryptedPassword = hashPassword(signUpDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new CustomException(e.getMessage());
        }

        User user = new User(signUpDto.getFirstName(), signUpDto.getLastName(),
                signUpDto.getEmail(), encryptedPassword);
        userRepository.save(user);

        final AuthenticationToken authenticationToken = new AuthenticationToken(user);

        authenticationService.saveConfirmationToken(authenticationToken);
        ResponseDto responseDto = new ResponseDto("success", "user registered successfully");

        return responseDto;
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();

        return hash;
    }

    public SignInResponseDto signIn(SignInDto signInDto) {
        User user = userRepository.findByEmail(signInDto.getEmail());

        if (Objects.isNull(user)) {
            throw new AutheticationFailExeception("user is not valid");
        }

        try {
            if (!user.getPassword().equals(hashPassword(signInDto.getPassword()))) {
                throw new AutheticationFailExeception("password is not valid");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        AuthenticationToken token = authenticationService.getToken(user);

        if (Objects.isNull(token)) {
            throw new CustomException("token is not present");
        }
        return new SignInResponseDto("success", token.getToken());
    }
}
