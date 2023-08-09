package com.blogoramaapi.application.usecases.impl.posts;

import com.blogoramaapi.application.usecases.posts.DeletePostsUseCase;
import com.blogoramaapi.domain.repositories.PostEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeletePostsUseCaseImpl implements DeletePostsUseCase {

    private final PostEntityRepository postEntityRepository;

    @Override
    public void deleteById(long id, String username) {
        postEntityRepository.findById(id).ifPresent(postEntity -> {
            String user = postEntity.getUser().getUsername();
            if (!user.equalsIgnoreCase(username)) throw new IllegalArgumentException("Error: You cannot update this post because you are not its owner.");
        });
        postEntityRepository.deleteById(id);
    }
}
