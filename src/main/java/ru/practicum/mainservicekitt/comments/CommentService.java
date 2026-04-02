package ru.practicum.mainservicekitt.comments;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    CommentResponseDto createComment(Long userId, Long eventId, NewCommentDto dto);

    CommentResponseDto updateComment(Long userId, Long commentId, NewCommentDto dto);

    List<CommentResponseDto> getCommentsByEventId(Long eventId);

    CommentResponseDto getCommentById(Long commentId);

    void deleteComment(Long userId, Long commentId);
}
