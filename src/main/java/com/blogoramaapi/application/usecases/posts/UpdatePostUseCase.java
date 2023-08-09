package com.blogoramaapi.application.usecases.posts;

import com.blogoramaapi.application.dtos.req.PostReqDto;

public interface UpdatePostUseCase {
    void execute(long id, PostReqDto postReqDto);
}
