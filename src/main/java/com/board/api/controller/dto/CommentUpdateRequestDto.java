package com.board.api.controller.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommentUpdateRequestDto implements Serializable {
    private Long commentId;
    private String comment;
}
