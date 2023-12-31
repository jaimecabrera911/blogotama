package com.blogoramaapi.application.dtos.res;

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
public class PermissionResDto {
    private String name;
    private String description;
}