package com.blogoramaapi.application.usecases.posts;

import com.blogoramaapi.application.dtos.req.PostReqDto;

public interface CreatePostUseCase {

    void execute(PostReqDto postReqDto);
}
