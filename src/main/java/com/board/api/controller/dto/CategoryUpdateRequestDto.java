package com.board.api.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CategoryUpdateRequestDto implements Serializable {
    private Long categoryId;
    private String code;
    private String name;
}
