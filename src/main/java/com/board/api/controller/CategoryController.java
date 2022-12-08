package com.board.api.controller;

import com.board.api.common.dto.ApiResponseDto;
import com.board.api.controller.dto.CategorySaveRequestDto;
import com.board.api.controller.dto.CategoryUpdateRequestDto;
import com.board.api.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    /**
     * 게시판 카테고리 조회 *
     * @param categoryId
     * @return
     * @throws Exception
     */
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?> findCategory(@PathVariable("categoryId") Long categoryId) throws Exception {
        return ResponseEntity.ok(new ApiResponseDto(categoryService.findCategory(categoryId)));
    }

    /**
     * 게시판 카테고리 목록 조회 *
     * @return
     * @throws Exception
     */
    @GetMapping("/category/list")
    public ResponseEntity<?> findCategoryList() throws Exception {
        return ResponseEntity.ok(new ApiResponseDto(categoryService.findCategoryList()));
    }

    /**
     * 게시판 카테고리 등록 *
     * @param saveRequestDto
     */
    @PostMapping("/category")
    public ResponseEntity<?> saveCategory(@RequestBody CategorySaveRequestDto saveRequestDto) {
        categoryService.saveCategory(saveRequestDto);
        return ResponseEntity.ok(new ApiResponseDto());
    }

    /**
     * 게시판 카테고리 수정 *
     * @param updateRequestDto
     */
    @PutMapping("/category")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryUpdateRequestDto updateRequestDto) {
        categoryService.updateCategory(updateRequestDto);
        return ResponseEntity.ok(new ApiResponseDto());
    }

    /**
     * 게시판 카테고리 삭제 *
     * @param categoryId
     */
    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") String categoryId) {
        categoryService.deleteCategory(categoryId);

        return ResponseEntity.ok(new ApiResponseDto());
    }
}
