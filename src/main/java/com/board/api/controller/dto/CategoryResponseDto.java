package com.board.api.controller.dto;

import com.board.api.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CategoryResponseDto implements Serializable {
    private Long categoryId;
    private String code;
    private String name;
    private Boolean useYn;

    public CategoryResponseDto(Category category) {
        this.categoryId = category.getCategoryId();
        this.code = category.getCode();
        this.name = category.getName();
        this.useYn = category.getUseYn();
    }
}
