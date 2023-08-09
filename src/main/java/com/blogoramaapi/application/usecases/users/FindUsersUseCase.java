package com.blogoramaapi.application.usecases.users;

import com.blogoramaapi.application.dtos.res.UserResDto;
import com.blogoramaapi.domain.entities.UserEntity;

public interface FindUsersUseCase {
    UserResDto findByUsernameOrEmail(String usernameOrEmail);

    UserEntity findUserEntityByUsername(String username);
}
