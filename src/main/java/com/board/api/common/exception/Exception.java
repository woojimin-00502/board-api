package com.board.api.common.exception;

import com.board.api.common.dto.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Exception {
    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ApiResponseDto> exceptionHandler(CommonException e) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseDto(e));
    }
}
