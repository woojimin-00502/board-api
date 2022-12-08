package com.board.api.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BoardUpdateRequestDto implements Serializable {
    private Long boardId;
    private String subject;
    private Long categoryId;
}
