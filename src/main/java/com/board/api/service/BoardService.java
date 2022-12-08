package com.board.api.service;

import com.board.api.common.exception.CommonException;
import com.board.api.common.exception.CommonExceptionCode;
import com.board.api.controller.dto.BoardResponseDto;
import com.board.api.controller.dto.BoardSaveRequestDto;
import com.board.api.controller.dto.BoardUpdateRequestDto;
import com.board.api.entity.Board;
import com.board.api.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    /**
     * 게시판 목록 조회 *
     * @param boardId
     * @return
     * @throws Exception
     */
    public BoardResponseDto findBoard(Long boardId) throws Exception {
        Board board = boardRepository.findByBoardId(boardId)
                .orElseThrow(() -> new CommonException(CommonExceptionCode.NO_DATA));

        BoardResponseDto resultDto = new BoardResponseDto(board);

        return resultDto;
    }

    /**
     * 게시판 조회 *
     * @return
     * @throws Exception
     */
    public List<BoardResponseDto> findBoardList() throws Exception {
        List<Board> boardList = boardRepository.findAll();

        if (CollectionUtils.isEmpty(boardList)) {
            throw new CommonException(CommonExceptionCode.NO_DATA);
        }

        return boardList.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

    /**
     * 게시판 등록 *
     * @param saveRequestDto
     */
    public void saveBoard(BoardSaveRequestDto saveRequestDto) {
        // 데이터 등록 로직 채우기
        Board board = Board.builder()
                .subject(saveRequestDto.getSubject())
                .categoryId(saveRequestDto.getCategoryId())
                .useYn(saveRequestDto.getUseYn())
                .build();

        boardRepository.save(board);
    }

    /**
     * 게시판 수정 *
     * @param updateRequestDto
     */
    public void updateBoard(BoardUpdateRequestDto updateRequestDto) {
        Board board = boardRepository.findById(updateRequestDto.getBoardId())
                .orElseThrow(() -> new CommonException(CommonExceptionCode.NO_DATA));

        // 데이터 update 로직 채우기
        board.updateData(updateRequestDto);

        boardRepository.save(board);
    }

    /**
     * 게시판 삭제 *
     * @param boardId
     */
    public void deleteBoard(String boardId) {
        Board board = boardRepository.findById(Long.parseLong(boardId))
                .orElseThrow(() -> new CommonException(CommonExceptionCode.NO_DATA));

        // 데이터 삭제 로직 채우기
        board.deleteData();

        boardRepository.save(board);
    }
}
