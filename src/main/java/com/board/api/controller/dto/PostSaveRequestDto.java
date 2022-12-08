package com.board.api.controller.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PostSaveRequestDto implements Serializable {
    private String subject;
    private Long boardId;
    private String contents;
}
