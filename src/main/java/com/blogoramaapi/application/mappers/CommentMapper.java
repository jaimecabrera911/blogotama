package com.blogoramaapi.application.mappers;

import com.blogoramaapi.application.dtos.req.CommentReqDto;
import com.blogoramaapi.application.dtos.res.CommentPostResDto;
import com.blogoramaapi.application.dtos.res.CommentResDto;
import com.blogoramaapi.domain.entities.CommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentMapper {
    CommentEntity toEntity(CommentReqDto commentReqDto);

    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "post.id", target = "postId")
    CommentResDto toResDto(CommentEntity commentEntity);


    @Mapping(source = "user.username", target = "username")
    CommentPostResDto toResPostDto(CommentEntity commentEntity);

}