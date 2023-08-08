package com.blogoramaapi.application.mappers;

import com.blogoramaapi.application.dtos.req.UserReqDto;
import com.blogoramaapi.application.dtos.res.UserResDto;
import com.blogoramaapi.domain.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserResDto toResDto(UserEntity userEntity);

    UserEntity toEntity(UserReqDto userReqDto);
}