package com.blogoramaapi.application.usecases.comments;

import com.blogoramaapi.application.dtos.req.CommentReqDto;

public interface CreateCommentUseCase {
    void execute(CommentReqDto commentReqDto);
}