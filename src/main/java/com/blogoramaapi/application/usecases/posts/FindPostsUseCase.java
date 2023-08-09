package com.blogoramaapi.application.usecases.posts;

import com.blogoramaapi.application.dtos.res.PostResDto;
import com.blogoramaapi.domain.entities.PostEntity;

import java.util.List;
import java.util.Optional;

public interface FindPostsUseCase {
    List<PostResDto> findPosts();

    List<PostResDto> findPostsByUsername(String username);

    Optional<PostEntity> findById(long id);

}
