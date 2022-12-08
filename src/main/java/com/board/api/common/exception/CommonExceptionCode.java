package com.board.api.common.exception;

import lombok.Getter;

@Getter
public enum CommonExceptionCode {
    NO_DATA("100000", "데이터가 존재하지 않습니다."),
    ;

    private String code;
    private String message;

    CommonExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
