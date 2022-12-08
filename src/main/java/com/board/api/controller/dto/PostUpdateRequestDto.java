package com.board.api.controller.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PostUpdateRequestDto implements Serializable {
    private Long postId;
    private String subject;
    private Long boardId;
    private String contents;
}
