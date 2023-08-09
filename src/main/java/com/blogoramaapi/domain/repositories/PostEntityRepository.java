package com.blogoramaapi.domain.repositories;

import com.blogoramaapi.domain.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PostEntityRepository extends JpaRepository<PostEntity, Long> {
    Set<PostEntity> findByUserUsernameOrderByCreationDateDesc(String username);

}