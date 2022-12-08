package com.board.api.repository;

import com.board.api.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByBoardId(Long boardId);
    Optional<Post> findByPostId(Long postId);

    void deleteByPostId(Long postId);
}
