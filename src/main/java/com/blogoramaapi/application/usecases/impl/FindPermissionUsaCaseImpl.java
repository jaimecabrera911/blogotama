package com.blogoramaapi.application.usecases.impl;

import com.blogoramaapi.application.dtos.res.PermissionResDto;
import com.blogoramaapi.application.mappers.PermissionMapper;
import com.blogoramaapi.application.usecases.impl.permissions.FindPermissionUsaCase;
import com.blogoramaapi.domain.repositories.PermissionEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindPermissionUsaCaseImpl implements FindPermissionUsaCase {

    private final PermissionEntityRepository permissionEntityRepository;
    private final PermissionMapper permissionMapper;

    @Override
    public List<PermissionResDto> getPermissions() {
        return permissionEntityRepository.findAll().stream().map(permissionMapper::toResponse).toList();
    }
}
