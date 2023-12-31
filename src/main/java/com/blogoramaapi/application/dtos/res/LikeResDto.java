package com.blogoramaapi.application.dtos.res;

import com.blogoramaapi.domain.entities.LikeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * DTO for {@link LikeEntity}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LikeResDto {
    private long postId;
    private boolean isLike;
    private String username;
    private LocalDate createdAt;

}