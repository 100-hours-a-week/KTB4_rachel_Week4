package kr.adadpterz.springboot_project.dto.like;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikeGetResponseDto {
    private LikeInfo likeInfo;

    public LikeGetResponseDto(Long postId, int likeNum) {
        this.likeInfo = new LikeInfo(likeNum, postId);
    }

    @Getter
    public static class LikeInfo {
        private int likeNum;
        private Long postId;

        public LikeInfo(int likeNum, Long postId) {
            this.likeNum = likeNum;
            this.postId = postId;
        }
    }
}