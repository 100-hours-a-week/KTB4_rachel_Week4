package kr.adadpterz.springboot_project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import kr.adadpterz.springboot_project.entity.Post;
import kr.adadpterz.springboot_project.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Comment {
    private Long commentId;

    private Post post;
    private User user;

    private String commentContent;
    private LocalDateTime createdAt;

    // 생성자에 뭘 넣어야 하지: 댓글을 처음 쓸때 무조건 채워야 하는 필수 알맹이들(POST 생각하기?)
    public Comment(Post post, User user, String commentContent) {
        this.post = post; // 그냥 이렇게 post 엔터티 전체를 넣는게 맞나..? (+ user 엔터티)
        this.user = user;
        this.commentContent = commentContent;

        this.createdAt = LocalDateTime.now();
    }

}
