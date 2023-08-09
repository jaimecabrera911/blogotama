package com.blogoramaapi.application.usecases.likes;

import com.blogoramaapi.application.dtos.req.LikeReqDto;

public interface GiveLikeUseCase {

    void execute(LikeReqDto likeReqDto);
}
