package com.blogoramaapi.infrastructure.security.services;

import com.blogoramaapi.application.dtos.req.UserReqDto;
import com.blogoramaapi.infrastructure.security.dtos.AuthReqDto;
import com.blogoramaapi.infrastructure.security.dtos.AuthResDto;

public interface AuthService {
    AuthResDto login(AuthReqDto authReqDto);

    void singUp(UserReqDto userReqDto);
}
