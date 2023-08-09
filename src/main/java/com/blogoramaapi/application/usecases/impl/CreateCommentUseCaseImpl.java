package com.blogoramaapi.application.usecases.impl;

import com.blogoramaapi.application.dtos.req.CommentReqDto;
import com.blogoramaapi.application.mappers.CommentMapper;
import com.blogoramaapi.application.usecases.comments.CreateCommentUseCase;
import com.blogoramaapi.application.usecases.posts.FindPostsUseCase;
import com.blogoramaapi.application.usecases.users.FindUsersUseCase;
import com.blogoramaapi.domain.entities.CommentEntity;
import com.blogoramaapi.domain.entities.PostEntity;
import com.blogoramaapi.domain.repositories.CommentEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateCommentUseCaseImpl implements CreateCommentUseCase {

    private final CommentEntityRepository commentEntityRepository;
    private final CommentMapper commentMapper;
    private final FindUsersUseCase findUsersUseCase;
    private final FindPostsUseCase findPostsUseCase;

    @Override
    public void execute(CommentReqDto commentReqDto) {
        CommentEntity commentEntity = commentMapper.toEntity(commentReqDto);
        findUsersUseCase.findUserEntityByUsername(commentReqDto.getUsername());
        PostEntity post = findPostsUseCase.findById(commentReqDto.getPostId()).orElseThrow(
                () -> new IllegalArgumentException("Error: post id not found")
        );
        commentEntity.setUser(post.getUser());
        commentEntity.setPost(post);
        commentEntityRepository.save(commentEntity);
    }
}
