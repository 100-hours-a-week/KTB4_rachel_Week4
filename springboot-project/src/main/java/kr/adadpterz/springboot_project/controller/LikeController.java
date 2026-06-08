package kr.adadpterz.springboot_project.controller;

import kr.adadpterz.springboot_project.dto.like.LikeGetResponseDto;
import kr.adadpterz.springboot_project.dto.like.LikeRequestDto;
import kr.adadpterz.springboot_project.dto.like.LikeResponseDto;
import kr.adadpterz.springboot_project.response.ApiResponse;
import kr.adadpterz.springboot_project.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("posts/{postId}")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @GetMapping("/likes")
    public ResponseEntity<ApiResponse<LikeGetResponseDto>> getLikes(
            @PathVariable Long postId
    ) {
        LikeGetResponseDto result = likeService.getLikeInfo(postId);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.of("LIKE_RETRIVER", result, null));
    }

    @PostMapping("/{userId}/likes")
    public ResponseEntity<ApiResponse<LikeResponseDto>> createLike(
            @PathVariable Long postId,
            @PathVariable Long userId,
            @RequestBody LikeRequestDto request
    ) {
        LikeResponseDto result = likeService.pressLike(postId, userId, request);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.of("LIKE_CREATE", result, null));
    }

    @DeleteMapping("/{userId}/likes")
    public ResponseEntity<ApiResponse<LikeResponseDto>> deleteLike(
            @PathVariable Long postId,
            @PathVariable Long userId
    ) {
        LikeResponseDto result = likeService.cancelLike(postId, userId);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.of("LIKE_DELETE", result, null));
    }
}
