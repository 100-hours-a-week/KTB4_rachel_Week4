package kr.adadpterz.springboot_project.dto.comment;

import kr.adadpterz.springboot_project.entity.Comment;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class CommentCreateResponseDto {
    private final Long commentId;
    private final LocalDateTime createdAt;

    public CommentCreateResponseDto(Comment comment) {
        this.commentId = comment.getCommentId();
        this.createdAt = comment.getCreatedAt();
    }
}