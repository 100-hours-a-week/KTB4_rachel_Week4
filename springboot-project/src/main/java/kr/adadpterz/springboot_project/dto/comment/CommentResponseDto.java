package kr.adadpterz.springboot_project.dto.comment;

import kr.adadpterz.springboot_project.entity.Comment;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private final Long commentId;
    private final Long postId;
    private final Long userId;
    private final String nickname;
    private final String content;
    private final LocalDateTime createdAt;

    public CommentResponseDto(Comment comment) {
        this.commentId = comment.getCommentId();
        this.postId = comment.getPost().getPostId();
        this.userId = comment.getUser().getId();         // 댓글 작성자 ID (User 객체가 있다고 가정)
        this.nickname = comment.getUser().getNickname(); // 댓글 작성자 닉네임
        this.content = comment.getCommentContent();
        this.createdAt = comment.getCreatedAt();
    }
}