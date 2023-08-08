package com.blogoramaapi.application.usecases.impl;

import com.blogoramaapi.application.dtos.res.PermissionResDto;

import java.util.List;

public interface FindPermissionUsaCase {

    List<PermissionResDto> getPermissions();
}
