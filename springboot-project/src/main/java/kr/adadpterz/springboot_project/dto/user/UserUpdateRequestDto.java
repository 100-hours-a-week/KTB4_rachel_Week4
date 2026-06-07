package kr.adadpterz.springboot_project.dto.user;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {

    @NotBlank(message = "닉네임이 비었습니다.")
    private String nickname;

    private String profileImage;
}
