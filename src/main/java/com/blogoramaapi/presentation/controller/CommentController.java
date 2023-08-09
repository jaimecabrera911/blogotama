package com.blogoramaapi.presentation.controller;

import com.blogoramaapi.application.dtos.req.CommentReqDto;
import com.blogoramaapi.application.usecases.comments.CreateCommentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CreateCommentUseCase createCommentUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@AuthenticationPrincipal UserDetails userDetails, @RequestBody CommentReqDto commentReqDto) {
        commentReqDto.setUsername(userDetails.getUsername());
        createCommentUseCase.execute(commentReqDto);
    }
}
