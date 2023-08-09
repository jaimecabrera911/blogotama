package com.blogoramaapi.application.usecases.posts;

public interface DeletePostsUseCase {
    void deleteById(long id, String username);
}
