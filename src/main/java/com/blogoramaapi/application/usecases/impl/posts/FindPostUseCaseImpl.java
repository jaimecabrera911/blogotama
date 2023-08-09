package com.blogoramaapi.application.usecases.impl.posts;

import com.blogoramaapi.application.dtos.res.PostResDto;
import com.blogoramaapi.application.mappers.PostMapper;
import com.blogoramaapi.application.usecases.posts.FindPostsUseCase;
import com.blogoramaapi.domain.entities.PostEntity;
import com.blogoramaapi.domain.repositories.PostEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.Sort.Order.desc;
import static org.springframework.data.domain.Sort.by;

@Component
@RequiredArgsConstructor
public class FindPostUseCaseImpl implements FindPostsUseCase {

    private final PostEntityRepository postEntityRepository;
    private final PostMapper postMapper;
    public static final Sort SORT = by(desc("creationDate"));

    @Override
    public List<PostResDto> findPosts() {
        return postEntityRepository.findAll(SORT).stream().map(postMapper::toResDto).toList();
    }

    @Override
    public Optional<PostEntity> findById(long id) {
        return postEntityRepository.findById(id);
    }

    @Override
    public List<PostResDto> findPostsByUsername(String username) {
        return postEntityRepository.findByUserUsernameOrderByCreationDateDesc(username).stream()
                .map(postMapper::toResDto).toList();
    }
}
