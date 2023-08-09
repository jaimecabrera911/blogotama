package com.blogoramaapi.application.dtos.res;

import com.blogoramaapi.domain.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

/**
 * DTO for {@link UserEntity}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserResDto {
    private String name;
    private String username;
    private String email;
    private Timestamp registrationDate;
    private boolean isEnabled;
    private List<PermissionResDto> permissions;
}