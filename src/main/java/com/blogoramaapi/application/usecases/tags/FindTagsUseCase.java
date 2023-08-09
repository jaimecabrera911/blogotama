package com.blogoramaapi.application.usecases.tags;

import com.blogoramaapi.domain.entities.TagEntity;

import java.util.List;


public interface FindTagsUseCase {

    TagEntity findByName(String name);

    List<TagEntity> findByNames(List<String> names);
}
