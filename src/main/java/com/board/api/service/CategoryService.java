package com.board.api.service;

import com.board.api.common.exception.CommonException;
import com.board.api.common.exception.CommonExceptionCode;
import com.board.api.controller.dto.CategoryResponseDto;
import com.board.api.controller.dto.CategorySaveRequestDto;
import com.board.api.controller.dto.CategoryUpdateRequestDto;
import com.board.api.entity.Category;
import com.board.api.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    /**
     * 게시판 카테고리 조회 *
     * @param categoryId
     * @return
     * @throws Exception
     */
    public CategoryResponseDto findCategory(Long categoryId) throws Exception {
        Category category = categoryRepository.findByCategoryId(categoryId)
                .orElseThrow(() -> new CommonException(CommonExceptionCode.NO_DATA));

        CategoryResponseDto resultDto = new CategoryResponseDto(category);

        return resultDto;
    }

    /**
     * 게시판 카테고리 조회 - 리스트 *
     * @return
     * @throws Exception
     */
    public List<CategoryResponseDto> findCategoryList() throws Exception {
        List<Category> categoryList = categoryRepository.findAll();

        if (CollectionUtils.isEmpty(categoryList)) {
            throw new CommonException(CommonExceptionCode.NO_DATA);
        }

        return categoryList.stream().map(CategoryResponseDto::new).collect(Collectors.toList());
    }

    /**
     * 게시판 카테고리 등록 *
     * @param saveRequestDto
     */
    public void saveCategory(CategorySaveRequestDto saveRequestDto) {
        // 데이터 등록 로직 채우기
        Category category = Category.builder()
                .code(saveRequestDto.getCode())
                .name(saveRequestDto.getName())
                .useYn(saveRequestDto.getUseYn())
                .build();

        categoryRepository.save(category);
    }

    /**
     * 게시판 카테고리 수정 *
     * @param updateRequestDto
     */
    public void updateCategory(CategoryUpdateRequestDto updateRequestDto) {
        Category category = categoryRepository.findById(updateRequestDto.getCategoryId())
                .orElseThrow(() -> new CommonException(CommonExceptionCode.NO_DATA));

        // 데이터 update 로직 채우기
        category.updateData(updateRequestDto);

        categoryRepository.save(category);
    }

    /**
     * 게시판 카테고리 삭제 *
     * @param categoryId
     */
    public void deleteCategory(String categoryId) {
        Category category = categoryRepository.findById(Long.parseLong(categoryId))
                .orElseThrow(() -> new CommonException(CommonExceptionCode.NO_DATA));

        // 데이터 삭제 로직 채우기
        category.deleteData();

        categoryRepository.save(category);
    }
}
