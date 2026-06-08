package kr.adadpterz.springboot_project.dto.comment;

import kr.adadpterz.springboot_project.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentResponseDto { // 댓글 전체 조회
    private Long commentId;
    private Long postId; // 이거 commentInfo로 한꺼번에 주려고햇는데..
    private Long userId;
    private String author;
    private String content;
    private LocalDateTime createdAt;

    // private final Long postId;

    public CommentResponseDto(Comment comment) {
        this.commentId = comment.getCommentId();
        this.postId = comment.getPost().getPostId();
        this.userId = comment.getUser().getId();         // 댓글 작성자 ID (User 객체가 있다고 가정)
        this.author = comment.getUser().getNickname(); // 댓글 작성자 닉네임
        this.content = comment.getCommentContent();
        this.createdAt = comment.getCreatedAt();
    }
}