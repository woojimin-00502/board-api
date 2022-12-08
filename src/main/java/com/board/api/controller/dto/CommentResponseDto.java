package com.board.api.controller.dto;

import com.board.api.entity.Comment;
import lombok.Data;

import java.io.Serializable;

@Data
public class CommentResponseDto implements Serializable {
    private Long commentId;
    private String comment;

    public CommentResponseDto(Comment comment) {
        this.commentId = comment.getCommentId();
        this.comment = comment.getComment();
    }
}
