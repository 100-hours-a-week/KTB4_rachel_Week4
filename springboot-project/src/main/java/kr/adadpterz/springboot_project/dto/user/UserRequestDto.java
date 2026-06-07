package kr.adadpterz.springboot_project.dto.user;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Getter
@NoArgsConstructor
public class UserRequestDto { // 회원가입 시 DTO

    @NotBlank(message = "이메일이 비어있습니다.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;

    @NotBlank(message = "비밀번호가 비었습니다.")
    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력해주세요.")
    private String password;

    @NotBlank(message = "비밀번호 확인이 비었습니다.")
    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력해주세요.")
    private String passwordCheck;

    @NotBlank(message = "닉네임이 비었습니다.")
    private String nickname;

    private String profileImage;
}
