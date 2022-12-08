package com.board.api.entity;

import com.board.api.controller.dto.CommentUpdateRequestDto;
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
@Table(catalog = "board", name = "comment")
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Size(max = 200)
    private String comment;

    private Long postId;

    private Long memberId;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDate;

    public void updateData(CommentUpdateRequestDto updateDto) {
        this.comment = updateDto.getComment();
    }
}
