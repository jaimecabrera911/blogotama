package com.blogoramaapi.application.usecases.impl;

import com.blogoramaapi.application.dtos.res.UserResDto;

public interface FindUserUseCase {
    UserResDto findByUsernameOrEmail(String usernameOrEmail);

    UserResDto findByUsername(String username);

    UserResDto findByEmail(String email);
}
