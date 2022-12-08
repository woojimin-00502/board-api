package com.board.api.common.exception;

import lombok.Getter;

@Getter
public class CommonException extends RuntimeException {
    private final String errorCode;
    private final String errorMessage;

    public CommonException(CommonExceptionCode commonExceptionCode) {
        this.errorCode = commonExceptionCode.getCode();
        this.errorMessage = commonExceptionCode.getMessage();
    }
}
