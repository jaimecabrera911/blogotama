package com.blogoramaapi.presentation.controller;

import com.blogoramaapi.application.dtos.res.UserResDto;
import com.blogoramaapi.application.usecases.impl.FindUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Objects;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final FindUserUseCase findUserUseCase;

    @GetMapping
    public UserResDto getUser(WebRequest webRequest) {
        String name = Objects.requireNonNull(webRequest.getUserPrincipal()).getName();
        return findUserUseCase.findByUsernameOrEmail(name);
    }

    @GetMapping("/{username}")
    public UserResDto findUserByUsernameOrEmail(@PathVariable String username) {
        return findUserUseCase.findByUsernameOrEmail(username);
    }
}
