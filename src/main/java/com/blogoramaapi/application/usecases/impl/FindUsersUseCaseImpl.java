package com.blogoramaapi.application.usecases.impl;

import com.blogoramaapi.application.dtos.res.UserResDto;
import com.blogoramaapi.application.mappers.UserMapper;
import com.blogoramaapi.application.usecases.users.FindUsersUseCase;
import com.blogoramaapi.domain.entities.UserEntity;
import com.blogoramaapi.domain.repositories.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class FindUsersUseCaseImpl implements FindUsersUseCase {

    private final UserEntityRepository userEntityRepository;
    private final UserMapper userMapper;

    @Override
    public UserResDto findByUsernameOrEmail(String usernameOrEmail) {
        return userMapper.toResDto(
                userEntityRepository.findByUsername(usernameOrEmail)
                        .orElseGet(() -> userEntityRepository.findByEmail(usernameOrEmail)
                                .orElseThrow(() -> new RuntimeException("User not found by username or email: " + usernameOrEmail)))
        );
    }

    @Override
    public UserEntity findUserEntityByUsername(String username) {
        return userEntityRepository.findByUsername(username).orElseThrow(
                () -> new RuntimeException("User not found by username: " + username)
        );
    }
}
