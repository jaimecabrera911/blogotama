package com.blogoramaapi.presentation.controller;

import com.blogoramaapi.application.dtos.req.LikeReqDto;
import com.blogoramaapi.application.usecases.likes.GiveLikeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/likes")
public class LikeController {

    private final GiveLikeUseCase giveLikeUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void giveLike(@AuthenticationPrincipal UserDetails userDetails, @RequestBody LikeReqDto likeReqDto) {
        likeReqDto.setUsername(userDetails.getUsername());
        giveLikeUseCase.execute(likeReqDto);
    }
}
