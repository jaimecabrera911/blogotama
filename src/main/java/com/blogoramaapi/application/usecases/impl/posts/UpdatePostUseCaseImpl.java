package com.blogoramaapi.application.usecases.impl.posts;

import com.blogoramaapi.application.dtos.req.PostReqDto;
import com.blogoramaapi.application.usecases.posts.FindPostsUseCase;
import com.blogoramaapi.application.usecases.posts.UpdatePostUseCase;
import com.blogoramaapi.application.usecases.tags.FindTagsUseCase;
import com.blogoramaapi.domain.entities.PostEntity;
import com.blogoramaapi.domain.entities.TagEntity;
import com.blogoramaapi.domain.repositories.PostEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class UpdatePostUseCaseImpl implements UpdatePostUseCase {

    private final FindPostsUseCase findPostsUseCase;
    private final FindTagsUseCase findTagsUseCase;
    private final PostEntityRepository postEntityRepository;

    @Override
    public void execute(long id, PostReqDto postReqDto) {
        PostEntity post = findPostsUseCase.findById(id).orElseThrow(
                () -> new RuntimeException("Error: post not found")
        );
        if (!post.getUser().getUsername().equalsIgnoreCase(postReqDto.getUsername())) {
            throw new IllegalArgumentException("Error: You cannot update this post because you are not its owner.");
        }
        try {
            postEntityRepository.updateTitleAndContentById(postReqDto.getTitle(), postReqDto.getContent(), id);
            List<TagEntity> tags = findTagsUseCase.findByNames(postReqDto.getTags());
            post.getTags().clear();
            //tags.forEach(post::removeTag);
            tags.forEach(post::addTag);
            postEntityRepository.save(post);
        } catch (RuntimeException exception) {
            log.error("error", exception);
            throw exception;
        }
    }
}
