package kr.adadpterz.springboot_project.dto.user;

import lombok.Getter;
import kr.adadpterz.springboot_project.entity.User;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto { // 회원가입 시 DTO
    private Long userId;


    public UserResponseDto(User user) {
        this.userId = user.getId();
    }
}
