package com.blogoramaapi.application.dtos.req;

import com.blogoramaapi.application.enums.Permissions;
import com.blogoramaapi.domain.entities.PermissionEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO for {@link PermissionEntity}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PermissionReqDto {
    private Permissions name;
    private String description;
}