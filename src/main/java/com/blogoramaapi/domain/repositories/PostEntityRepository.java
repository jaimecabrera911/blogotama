package com.blogoramaapi.domain.repositories;

import com.blogoramaapi.domain.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PostEntityRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findByUserUsernameOrderByCreationDateDesc(String username);

    @Transactional
    @Modifying
    @Query("update PostEntity p set p.title = ?1, p.content = ?2 where p.id = ?3")
    void updateTitleAndContentById(String title, String content, Long id);
}