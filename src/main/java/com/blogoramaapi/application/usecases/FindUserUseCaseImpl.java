package com.blogoramaapi.application.usecases;

import com.blogoramaapi.application.dtos.res.UserResDto;
import com.blogoramaapi.application.mappers.UserMapper;
import com.blogoramaapi.application.usecases.impl.FindUserUseCase;
import com.blogoramaapi.domain.repositories.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class FindUserUseCaseImpl implements FindUserUseCase {

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
    public UserResDto findByUsername(String username) {
        return userMapper.toResDto(userEntityRepository.findByUsername(username).orElseThrow());
    }

    @Override
    public UserResDto findByEmail(String email) {
        return userMapper.toResDto(userEntityRepository.findByEmail(email).orElseThrow());
    }

}
