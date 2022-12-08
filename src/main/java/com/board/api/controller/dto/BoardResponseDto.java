package com.board.api.controller.dto;

import com.board.api.entity.Board;
import com.board.api.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BoardResponseDto implements Serializable {
    private Long boardId;
    private String subject;
    private Long categoryId;
    private Boolean useYn;

    public BoardResponseDto(Board board) {
        this.boardId = board.getCategoryId();
        this.subject = board.getSubject();
        this.categoryId = board.getCategoryId();
        this.useYn = board.getUseYn();
    }
}
