package com.blogoramaapi.domain.repositories;

import com.blogoramaapi.domain.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentEntityRepository extends JpaRepository<CommentEntity, Long> {
}