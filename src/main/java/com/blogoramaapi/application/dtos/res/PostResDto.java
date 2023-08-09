package com.blogoramaapi.application.dtos.res;

import com.blogoramaapi.domain.entities.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

/**
 * DTO for {@link PostEntity}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostResDto {
    private long id;
    private String title;
    private String content;
    private Timestamp creationDate;
    private String user;
    private List<String> tags;
    private List<CommentPostResDto> comments;
    private long numLikes;
    private long numDislikes;
    private List<LikePostResPostDto> likes;
}