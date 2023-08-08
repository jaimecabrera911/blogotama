package com.blogoramaapi.application.mappers;

import com.blogoramaapi.application.dtos.res.PermissionResDto;
import com.blogoramaapi.domain.entities.PermissionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PermissionMapper {
    PermissionResDto toResponse(PermissionEntity permissionEntity);
}