package com.board.api.service;

import com.board.api.common.exception.CommonException;
import com.board.api.common.exception.CommonExceptionCode;
import com.board.api.controller.dto.PostResponseDto;
import com.board.api.controller.dto.PostSaveRequestDto;
import com.board.api.controller.dto.PostUpdateRequestDto;
import com.board.api.entity.Post;
import com.board.api.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostResponseDto> selectPostList(Long boardId) {
        List<Post> postList = postRepository.findAllByBoardId(boardId);

        if (!CollectionUtils.isEmpty(postList)) {
            throw new CommonException(CommonExceptionCode.NO_DATA);
        }

        return postList.stream().map(PostResponseDto::new).collect(Collectors.toList());

    }

    public PostResponseDto selectPost(Long postId) throws Exception {
        return new PostResponseDto(
                postRepository.findByPostId(postId)
                .orElseThrow(() -> new CommonException(CommonExceptionCode.NO_DATA))
        );
    }

    public void savePost(PostSaveRequestDto saveDto) {
        Post post = Post.builder()
                .subject(saveDto.getSubject())
                .contents(saveDto.getContents())
                .boardId(saveDto.getBoardId())
                .build();

        postRepository.save(post);
    }

    public void updatePost(PostUpdateRequestDto updateDto) {
        Post post = postRepository.findByPostId(updateDto.getPostId())
                .orElseThrow(() -> new CommonException(CommonExceptionCode.NO_DATA));

        post.updateData(updateDto);

        postRepository.save(post);
    }

    public void deletePost(Long postId) {
        postRepository.deleteByPostId(postId);
    }
}
