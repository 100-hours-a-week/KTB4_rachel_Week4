package kr.adadpterz.springboot_project.dto.comment;

import kr.adadpterz.springboot_project.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentDeleteResponseDto {
    private Long commentId;
    private Long postId;
    private Long userId;
    private int commentNum;

    public CommentDeleteResponseDto(Comment comment, int commentNum) {
        this.commentId = comment.getCommentId();
        this.postId = comment.getPost().getPostId();
        this.userId = comment.getUser().getId();
        this.commentNum = commentNum;
    }
}
