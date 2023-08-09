package com.blogoramaapi.application.dtos.req;

import com.blogoramaapi.domain.entities.LikeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO for {@link LikeEntity}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LikeReqDto {
    private long postId;
    private boolean isLike;
    private String username;
}