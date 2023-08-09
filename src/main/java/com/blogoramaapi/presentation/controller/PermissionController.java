package com.blogoramaapi.presentation.controller;

import com.blogoramaapi.application.dtos.res.PermissionResDto;
import com.blogoramaapi.application.usecases.impl.permissions.FindPermissionUsaCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final FindPermissionUsaCase findPermissionUsaCase;

    @GetMapping
    public List<PermissionResDto> getPermissions() {
        return findPermissionUsaCase.getPermissions();
    }
}
