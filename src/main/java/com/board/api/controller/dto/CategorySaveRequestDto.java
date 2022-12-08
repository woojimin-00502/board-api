package com.board.api.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CategorySaveRequestDto implements Serializable {
    private String code;
    private String name;
    private Boolean useYn;

    public CategorySaveRequestDto() {
        this.code = "FREE";
        this.useYn = true;

    }
}
