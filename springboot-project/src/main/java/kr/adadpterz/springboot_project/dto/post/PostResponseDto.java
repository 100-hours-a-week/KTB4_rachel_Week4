package kr.adadpterz.springboot_project.dto.post;

import lombok.Getter;
import kr.adadpterz.springboot_project.dto.comment.CommentResponseDto;
import kr.adadpterz.springboot_project.entity.User;
import kr.adadpterz.springboot_project.entity.Post;
import lombok.NoArgsConstructor;

import java.util.List;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private Long postId;

    private String title;
    private String content;
    private String image;
    private Long authorId; // 기존 명세서에서 수정함. author, nickname 없애고, userId를 authorId라 함
    private String nickname;
    private int viewCount;
    // private int likeCount;
    private int commentCount;

    private List<CommentResponseDto> comments;

    private LocalDateTime createdAt;



    public PostResponseDto(Post post) {
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.authorId = post.getAuthor().getId();
        this.nickname = post.getAuthor().getNickname();
        this.content = post.getContent();
        this.image = post.getImage();

        // this.likeCount = 0; // 좋아요도 따로 엔터티말들고 dto 등을 만들거임.
        this.viewCount = post.getViewCount();
        this.commentCount = post.getComments().size();

        this.createdAt = post.getCreatedAt();

        this.comments = post.getComments().stream()
                .map(comment -> new CommentResponseDto(comment))
                .collect(Collectors.toList());

    }
}
