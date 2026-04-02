package ru.practicum.mainservicekitt.comments;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentMapper {
    Comment toComment(NewCommentDto newCommentDto);

    CommentResponseDto toCommentResponseDto(Comment comment);
}
