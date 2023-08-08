package com.blogoramaapi.domain.repositories;

import com.blogoramaapi.domain.entities.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionEntityRepository extends JpaRepository<PermissionEntity, Integer> {
}