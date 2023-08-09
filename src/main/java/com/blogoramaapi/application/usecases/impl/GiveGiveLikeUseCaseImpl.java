package com.blogoramaapi.application.usecases.impl;

import com.blogoramaapi.application.dtos.req.LikeReqDto;
import com.blogoramaapi.application.usecases.likes.GiveLikeUseCase;
import com.blogoramaapi.application.usecases.posts.FindPostsUseCase;
import com.blogoramaapi.application.usecases.users.FindUsersUseCase;
import com.blogoramaapi.domain.entities.LikeEntity;
import com.blogoramaapi.domain.entities.PostEntity;
import com.blogoramaapi.domain.entities.UserEntity;
import com.blogoramaapi.domain.repositories.LikeEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GiveGiveLikeUseCaseImpl implements GiveLikeUseCase {

    private final LikeEntityRepository likeEntityRepository;
    private final FindPostsUseCase findPostsUseCase;
    private final FindUsersUseCase findUsersUseCase;

    @Override
    public void execute(LikeReqDto likeReqDto) {
        PostEntity post = findPostsUseCase.findById(likeReqDto.getPostId()).orElseThrow(
                () -> new RuntimeException("Error: post id not found")
        );
        UserEntity userEntity = findUsersUseCase.findUserEntityByUsername(likeReqDto.getUsername());
        LikeEntity likeEntity = LikeEntity.builder()
                .post(post)
                .isLike(likeReqDto.isLike())
                .user(userEntity)
                .build();
        likeEntityRepository.save(likeEntity);
    }
}
