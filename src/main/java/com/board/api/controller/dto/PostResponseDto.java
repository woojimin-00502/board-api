package com.board.api.controller.dto;

import com.board.api.entity.Post;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class PostResponseDto implements Serializable {
    private Long postId;
    private String subject;
    private Long boardId;
    private String contents;
    private LocalDateTime regDate;

    public PostResponseDto (Post post) {
        this.postId = post.getPostId();
        this.subject = post.getSubject();
        this.boardId = post.getBoardId();
        this.contents = post.getContents();
    }
}
