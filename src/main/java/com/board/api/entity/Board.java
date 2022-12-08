package com.board.api.entity;

import com.board.api.controller.dto.BoardUpdateRequestDto;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(catalog = "board", name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Size(max = 100)
    private String subject;

    private Long categoryId;

    @Type(type = "yes_no")
    private Boolean useYn;

    @CreatedDate
    private LocalDateTime regDate;

    public void updateData(BoardUpdateRequestDto updateRequestDto) {
        this.subject = updateRequestDto.getSubject();
        this.categoryId = updateRequestDto.getCategoryId();
    }

    public void deleteData() {
        this.useYn = false;
    }
}
