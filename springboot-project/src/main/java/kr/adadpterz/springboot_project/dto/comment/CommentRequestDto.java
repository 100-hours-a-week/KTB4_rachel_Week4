package kr.adadpterz.springboot_project.dto.comment;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import kr.adadpterz.springboot_project.entity.Comment;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequestDto {

    private String commentContent;;

    @NotNull(message = "user id가 비었습니다.")
    private Long userId;
}
