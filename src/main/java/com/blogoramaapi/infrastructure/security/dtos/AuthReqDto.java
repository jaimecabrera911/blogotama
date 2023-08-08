package com.blogoramaapi.infrastructure.security.dtos;

import lombok.Data;

@Data
public class AuthReqDto {
    private String username;
    private String password;
}
