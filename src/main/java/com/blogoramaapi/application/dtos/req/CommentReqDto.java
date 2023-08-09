package com.blogoramaapi.application.dtos.req;

import com.blogoramaapi.domain.entities.CommentEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO for {@link CommentEntity}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CommentReqDto {
    private long postId;
    private String text;
    @JsonIgnore
    private String username;
}