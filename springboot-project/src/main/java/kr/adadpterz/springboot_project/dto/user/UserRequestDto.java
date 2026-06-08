package kr.adadpterz.springboot_project.dto.user;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Max;

@Getter
@NoArgsConstructor
public class UserRequestDto { // 회원가입 시 DTO

    @NotBlank(message = "이메일이 비어있습니다.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;

    @NotBlank(message = "비밀번호가 비었습니다.")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
            message = "비밀번호는 대소문자, 숫자, 특수문자를 각각 최소 1개 이상 포함해야 합니다."
    )
    private String password;

    @NotBlank(message = "비밀번호 확인이 비었습니다.")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
            message = "비밀번호는 대소문자, 숫자, 특수문자를 각각 최소 1개 이상 포함해야 합니다."
    )
    private String passwordCheck;

    @NotBlank(message = "닉네임이 비었습니다.")
    @Pattern(regexp = "^\\S+$", message = "띄어쓰기(공백)를 포함할 수 없습니다.")
    @Size(max = 10, message = "닉네임은 10자 이내여야 합니다.")
    private String nickname;

    private String profileImage;
}
