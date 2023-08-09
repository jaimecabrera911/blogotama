package com.blogoramaapi.application.usecases.impl.posts;

import com.blogoramaapi.application.dtos.req.PostReqDto;
import com.blogoramaapi.application.mappers.PostMapper;
import com.blogoramaapi.application.usecases.tags.FindTagsUseCase;
import com.blogoramaapi.application.usecases.users.FindUsersUseCase;
import com.blogoramaapi.application.usecases.posts.CreatePostUseCase;
import com.blogoramaapi.domain.entities.PostEntity;
import com.blogoramaapi.domain.entities.TagEntity;
import com.blogoramaapi.domain.entities.UserEntity;
import com.blogoramaapi.domain.repositories.PostEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class CreatePostUseCaseImpl implements CreatePostUseCase {

    private final PostMapper postMapper;
    private final PostEntityRepository postEntityRepository;
    private final FindUsersUseCase findUsersUseCase;
    private final FindTagsUseCase findTagsUseCase;

    @Override
    public void execute(PostReqDto postReqDto) {
        PostEntity post = postMapper.toEntity(postReqDto);
        UserEntity userEntity = findUsersUseCase.findUserEntityByUsername(postReqDto.getUsername());
        Set<String> tagsNames = postReqDto.getTags();
        Set<TagEntity> tags = findTagsUseCase.findByNames(tagsNames);
        post.setTags(tags);
        post.setUser(userEntity);
        postEntityRepository.save(post);
    }
}
