package kr.adadpterz.springboot_project.dto.user;

import lombok.Getter;
import kr.adadpterz.springboot_project.entity.User;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

public class UserUpdateResponseDto {
    private Long userId;
    private String nickname;
    private String profileImage;

    public UserUpdateResponseDto(User user){
        this.userId = user.getId();
        this.nickname = user.getNickname();
        this.profileImage = user.getProfileImage();
    }
}
