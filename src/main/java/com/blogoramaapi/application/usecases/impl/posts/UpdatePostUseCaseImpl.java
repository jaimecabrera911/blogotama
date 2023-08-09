package com.blogoramaapi.application.usecases.impl.posts;

import com.blogoramaapi.application.dtos.req.PostReqDto;
import com.blogoramaapi.application.usecases.posts.FindPostsUseCase;
import com.blogoramaapi.application.usecases.posts.UpdatePostUseCase;
import com.blogoramaapi.application.usecases.tags.FindTagsUseCase;
import com.blogoramaapi.domain.entities.PostEntity;
import com.blogoramaapi.domain.entities.TagEntity;
import com.blogoramaapi.domain.repositories.PostEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
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
        Set<TagEntity> tags = findTagsUseCase.findByNames(postReqDto.getTags());
        post.setTitle(postReqDto.getTitle());
        post.setContent(postReqDto.getContent());
        post.setTags(tags);
        postEntityRepository.save(post);
    }
}
