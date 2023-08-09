package com.blogoramaapi.application.dtos.req;

import com.blogoramaapi.domain.entities.PostEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link PostEntity}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostReqDto implements Serializable {
    private String title;
    private String content;
    @JsonIgnore
    private String username;
    private Set<String> tags;
}