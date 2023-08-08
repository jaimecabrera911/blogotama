package com.blogoramaapi.application.dtos.res;

import com.blogoramaapi.domain.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.util.Set;

/**
 * DTO for {@link UserEntity}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class UserResDto {
    private String name;
    private String username;
    private String email;
    private Timestamp registrationDate;
    private boolean isEnabled;
    private Set<PermissionResDto> permissions;
}