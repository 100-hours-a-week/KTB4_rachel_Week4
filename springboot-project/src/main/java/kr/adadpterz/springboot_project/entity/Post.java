package kr.adadpterz.springboot_project.entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
// @Entity
public class Post {
    private Long postId;

    private String title;
    private String content;
    private String image;
    private User author;

    private List<Comment> comments = new ArrayList<>(); // 이거 여러개일텐데 어떻게 받아오지

    private int viewCount; // int랑 Integer 뭐가 달라
    private LocalDateTime createdAt; //

    public Post(String title, String content, String image, User author) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.author = author;

        this.createdAt = LocalDateTime.now();
    }


    // 제목 수정
    public void changeTitle(String title) { this.title = title; }

    // 내용 수정
    public void changeContent(String content) { this.content = content; }

    // 이미지 수정
    public void changeImage(String image) { this.image = image; }


}
