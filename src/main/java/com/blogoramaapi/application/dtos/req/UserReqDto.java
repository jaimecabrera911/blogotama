package com.blogoramaapi.application.dtos.req;

import com.blogoramaapi.domain.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * DTO for {@link UserEntity}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class UserReqDto {
    private String name;
    private String username;
    private String email;
    private String password;
}