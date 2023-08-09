package com.blogoramaapi.application.mappers;

import com.blogoramaapi.application.dtos.req.PostReqDto;
import com.blogoramaapi.application.dtos.res.PostResDto;
import com.blogoramaapi.domain.entities.PostEntity;
import com.blogoramaapi.domain.entities.TagEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {UserMapper.class},
        builder = @Builder(disableBuilder = true)
)
public interface PostMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "tags", ignore = true)
    PostResDto toResDto(PostEntity postEntity);

    @AfterMapping
    default void toResDtoAfterMapping(PostEntity postEntity, @MappingTarget PostResDto postResDto) {
        Set<String> tags = postEntity.getTags().stream().map(TagEntity::getName).collect(toSet());
        postResDto.setTags(tags);
    }

    @AfterMapping
    default void linkUser(PostEntity postEntity, @MappingTarget PostResDto postResDto) {
        postResDto.setUser(postEntity.getUser().getUsername());
    }

    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "user", ignore = true)
    PostEntity toEntity(PostReqDto postReqDto);
}