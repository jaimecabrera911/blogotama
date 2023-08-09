package com.blogoramaapi.domain.repositories;

import com.blogoramaapi.domain.entities.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeEntityRepository extends JpaRepository<LikeEntity, Long> {
}