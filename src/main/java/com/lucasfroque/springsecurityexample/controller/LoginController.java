package com.lucasfroque.springsecurityexample.controller;

import com.lucasfroque.springsecurityexample.dto.request.TokenForm;
import com.lucasfroque.springsecurityexample.security.jwt.JwtTokenService;
import com.lucasfroque.springsecurityexample.dto.request.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    AuthenticationManager authManager;
    @Autowired
    JwtTokenService tokenService;


    @PostMapping
    public ResponseEntity<TokenForm> login(@RequestBody @Valid LoginForm loginForm) {
        UsernamePasswordAuthenticationToken userPasswordToken = loginForm.toUsernamePasswordAuthenticationToken();
        try{
            Authentication authentication = authManager.authenticate(userPasswordToken);
            String token = String.format("Bearer %s", tokenService.generateToken(authentication));
            return ResponseEntity.ok(new TokenForm(token));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
