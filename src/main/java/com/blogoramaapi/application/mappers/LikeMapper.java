package com.blogoramaapi.application.mappers;

import com.blogoramaapi.application.dtos.res.LikePostResPostDto;
import com.blogoramaapi.domain.entities.LikeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LikeMapper {

    @Mapping(source = "user.username", target = "username")
    LikePostResPostDto toPostResDto(LikeEntity likeEntity);
}
