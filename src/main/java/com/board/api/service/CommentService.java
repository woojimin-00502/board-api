package com.board.api.service;

import com.board.api.common.exception.CommonException;
import com.board.api.common.exception.CommonExceptionCode;
import com.board.api.controller.dto.CommentResponseDto;
import com.board.api.controller.dto.CommentSaveRequestDto;
import com.board.api.controller.dto.CommentUpdateRequestDto;
import com.board.api.entity.Comment;
import com.board.api.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public List<CommentResponseDto> selectCommentList(Long boardId) {
        List<Comment> commentList = commentRepository.findAllByPostId(boardId);

        if (!CollectionUtils.isEmpty(commentList)) {
            throw new CommonException(CommonExceptionCode.NO_DATA);
        }

        return commentList.stream().map(CommentResponseDto::new).collect(Collectors.toList());

    }

    public void saveComment(CommentSaveRequestDto saveDto) {
        Comment comment = Comment.builder()
                .comment(saveDto.getComment())
                .postId(saveDto.getPostId())
                .build();

        commentRepository.save(comment);
    }

    public void updateComment(CommentUpdateRequestDto updateDto) {
        Comment comment = commentRepository.findByCommentId(updateDto.getCommentId())
                .orElseThrow(() -> new CommonException(CommonExceptionCode.NO_DATA));

        comment.updateData(updateDto);

        commentRepository.save(comment);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteByCommentId(commentId);
    }
}
