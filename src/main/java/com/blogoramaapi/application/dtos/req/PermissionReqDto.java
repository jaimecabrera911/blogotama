package com.blogoramaapi.application.dtos.req;

import com.blogoramaapi.domain.entities.PermissionEntity;
import com.blogoramaapi.application.enums.Permissions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * DTO for {@link PermissionEntity}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class PermissionReqDto {
    private Permissions name;
    private String description;
}