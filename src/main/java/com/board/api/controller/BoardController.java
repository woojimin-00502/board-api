package com.board.api.controller;

import com.board.api.common.dto.ApiResponseDto;
import com.board.api.controller.dto.BoardSaveRequestDto;
import com.board.api.controller.dto.BoardUpdateRequestDto;
import com.board.api.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    /**
     * 게시판 조회 *
     * @param boardId
     * @return
     * @throws Exception
     */
    @GetMapping("/board/{boardId}")
    public ResponseEntity<?> findBoard(@PathVariable("boardId") Long boardId) throws Exception {
        return ResponseEntity.ok(new ApiResponseDto(boardService.findBoard(boardId)));
    }

    /**
     * 게시판 목록 조회 *
     * @return
     * @throws Exception
     */
    @GetMapping("/board/list")
    public ResponseEntity<?> findBoardList() throws Exception {
        return ResponseEntity.ok(new ApiResponseDto(boardService.findBoardList()));
    }

    /**
     * 게시판 등록 *
     * @param saveRequestDto
     */
    @PostMapping("/board")
    public ResponseEntity<?> saveBoard(@RequestBody BoardSaveRequestDto saveRequestDto) {
        boardService.saveBoard(saveRequestDto);
        return ResponseEntity.ok(new ApiResponseDto());
    }

    /**
     * 게시판 수정 *
     * @param updateRequestDto
     */
    @PutMapping("/board")
    public ResponseEntity<?> updateBoard(@RequestBody BoardUpdateRequestDto updateRequestDto) {
        boardService.updateBoard(updateRequestDto);
        return ResponseEntity.ok(new ApiResponseDto());
    }

    /**
     * 게시판 삭제 *
     * @param boardId
     */
    @DeleteMapping("/board/{boardId}")
    public ResponseEntity<?> deleteBoard(@PathVariable("boardId") String boardId) {
        boardService.deleteBoard(boardId);

        return ResponseEntity.ok(new ApiResponseDto());
    }

}
