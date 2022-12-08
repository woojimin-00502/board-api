package com.board.api.controller.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommentSaveRequestDto implements Serializable {
    private Long commentId;
    private String comment;
    private Long postId;
}
