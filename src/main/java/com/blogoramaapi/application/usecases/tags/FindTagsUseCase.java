package com.blogoramaapi.application.usecases.tags;

import com.blogoramaapi.domain.entities.TagEntity;

import java.util.Set;


public interface FindTagsUseCase {

    TagEntity findByName(String name);

    Set<TagEntity> findByNames(Set<String> names);
}
