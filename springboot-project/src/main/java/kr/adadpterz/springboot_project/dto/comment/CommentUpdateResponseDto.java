package kr.adadpterz.springboot_project.dto.comment;


import jakarta.validation.constraints.NotBlank;
import kr.adadpterz.springboot_project.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentUpdateResponseDto {
    private Long commentId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CommentUpdateResponseDto(Comment comment){
        this.commentId = comment.getCommentId();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = LocalDateTime.now();
    }
}
