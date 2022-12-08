package com.board.api.entity;

import com.board.api.controller.dto.PostUpdateRequestDto;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(catalog = "board", name = "post")
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Size(max = 100)
    private String subject;

    private Long boardId;

    private String contents;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDate;

    public void updateData(PostUpdateRequestDto updateDto) {
        this.subject = updateDto.getSubject();
        this.boardId = updateDto.getBoardId();
        this.contents = updateDto.getContents();
    }
}
