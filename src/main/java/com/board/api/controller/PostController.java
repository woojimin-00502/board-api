package com.board.api.controller;

import com.board.api.common.dto.ApiResponseDto;
import com.board.api.controller.dto.PostSaveRequestDto;
import com.board.api.controller.dto.PostUpdateRequestDto;
import com.board.api.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    /**
     * 게시글 목록 조회 *
     * @param boardId
     * @return
     * @throws Exception
     */
    @GetMapping("/post/list/{boardId}")
    public ResponseEntity<?> findPostList(@PathVariable("boardId") Long boardId) {
        return ResponseEntity.ok(new ApiResponseDto(postService.selectPostList(boardId)));
    }

    /**
     * 게시글 조회 *
     * @param postId
     * @return
     * @throws Exception
     */
    @GetMapping("/post/{postId}")
    public ResponseEntity<?> findPost(@PathVariable("postId") Long postId) throws Exception {
        return ResponseEntity.ok(new ApiResponseDto(postService.selectPost(postId)));
    }

    /**
     * 게시글 생성 *
     * @param saveDto
     * @return
     * @throws Exception
     */
    @PostMapping("/post")
    public ResponseEntity<?> savePost(@RequestBody PostSaveRequestDto saveDto) {
        postService.savePost(saveDto);
        return ResponseEntity.ok(new ApiResponseDto());
    }

    /**
     * 게시글 수정 *
     * @param updateDto
     * @return
     * @throws Exception
     */
    @PutMapping("/post")
    public ResponseEntity<?> updatePost(@RequestBody PostUpdateRequestDto updateDto) {
        postService.updatePost(updateDto);
        return ResponseEntity.ok(new ApiResponseDto());
    }

    /**
     * 게시글 삭제 *
     * @param postId
     * @return
     * @throws Exception
     */
    @DeleteMapping("/post/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable("postId") Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.ok(new ApiResponseDto());
    }
}
