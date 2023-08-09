package com.blogoramaapi.application.usecases.impl;

import com.blogoramaapi.application.usecases.tags.FindTagsUseCase;
import com.blogoramaapi.domain.entities.TagEntity;
import com.blogoramaapi.domain.repositories.TagEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Set;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class FindTagsUseCaseImpl implements FindTagsUseCase {

    private final TagEntityRepository tagEntityRepository;


    @Override
    public TagEntity findByName(String name) {
        return tagEntityRepository.findByName(name).orElseThrow(
                () -> new RuntimeException(MessageFormat.format("Could not find tag {0}", name))
        );
    }

    @Override
    public Set<TagEntity> findByNames(Set<String> names) {
        return names.stream().map(this::findByName).collect(Collectors.toSet());
    }
}
