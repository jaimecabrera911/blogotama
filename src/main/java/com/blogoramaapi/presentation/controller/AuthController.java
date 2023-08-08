package com.blogoramaapi.presentation.controller;

import com.blogoramaapi.application.dtos.req.UserReqDto;
import com.blogoramaapi.infrastructure.security.dtos.AuthReqDto;
import com.blogoramaapi.infrastructure.security.dtos.AuthResDto;
import com.blogoramaapi.infrastructure.security.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public AuthResDto login(@RequestBody AuthReqDto authReqDto) {
        return authService.login(authReqDto);
    }

    @PostMapping("/sing-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody UserReqDto userReqDto) {
        authService.singUp(userReqDto);
    }
}
