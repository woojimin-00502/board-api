package com.board.api.controller;

import com.board.api.common.dto.ApiResponseDto;
import com.board.api.controller.dto.CommentSaveRequestDto;
import com.board.api.controller.dto.CommentUpdateRequestDto;
import com.board.api.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    /**
     * 댓글 조회 *
     * @param postId
     * @return
     * @throws Exception
     */
    @GetMapping("/comment/list/{postId}")
    public ResponseEntity<?> findPostList(@PathVariable("postId") Long postId) {
        return ResponseEntity.ok(new ApiResponseDto(commentService.selectCommentList(postId)));
    }

    /**
     * 댓글 생성 *
     * @param saveDto
     * @return
     * @throws Exception
     */
    @PostMapping("/comment")
    public ResponseEntity<?> savePost(@RequestBody CommentSaveRequestDto saveDto) {
        commentService.saveComment(saveDto);
        return ResponseEntity.ok(new ApiResponseDto());
    }

    /**
     * 댓글 수정 *
     * @param updateDto
     * @return
     * @throws Exception
     */
    @PutMapping("/comment")
    public ResponseEntity<?> updateComment(@RequestBody CommentUpdateRequestDto updateDto) {
        commentService.updateComment(updateDto);
        return ResponseEntity.ok(new ApiResponseDto());
    }

    /**
     * 댓글 삭제 *
     * @param postId
     * @return
     * @throws Exception
     */
    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable("commentId") Long postId) {
        commentService.deleteComment(postId);
        return ResponseEntity.ok(new ApiResponseDto());
    }
}
