package com.blogoramaapi.application.usecases.impl.permissions;

import com.blogoramaapi.application.dtos.res.PermissionResDto;

import java.util.List;

public interface FindPermissionUsaCase {

    List<PermissionResDto> getPermissions();
}
