package kr.adadpterz.springboot_project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private String profileImage;


    public User(String email, String password, String nickname, String profileImage) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.profileImage = (profileImage == null || profileImage.isEmpty()) ? "default_profile.png" : profileImage;
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
    } // 이게 왜 서비스 계층이 아니지

    public void changeProfileImage(String profileImage) { this.profileImage = profileImage; }

    public void changePassword(String password) {this.password = password; }
}
