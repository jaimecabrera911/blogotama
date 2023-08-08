package com.blogoramaapi.application.dtos.res;

import com.blogoramaapi.domain.entities.PermissionEntity;
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
public class PermissionResDto {
    private String name;
    private String description;
}