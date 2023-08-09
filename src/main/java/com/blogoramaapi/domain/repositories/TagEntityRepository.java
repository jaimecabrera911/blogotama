package com.blogoramaapi.domain.repositories;

import com.blogoramaapi.domain.entities.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagEntityRepository extends JpaRepository<TagEntity, Long> {
    Optional<TagEntity> findByName(String name);

}