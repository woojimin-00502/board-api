package com.board.api.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BoardSaveRequestDto implements Serializable {
    private String subject;
    private Long categoryId;
    private Boolean useYn;

    public BoardSaveRequestDto() {
        this.useYn = true;

    }
}
