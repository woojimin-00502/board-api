package com.board.api.repository;

import com.board.api.entity.Comment;
import com.board.api.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostId(Long PostId);

    Optional<Comment> findByCommentId(Long commentId);

    void deleteByCommentId(Long commentId);
}
