package com.annotations.domain.exception;

import com.annotations.domain.enun.ErrorEnum;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private final String message;
    private final Integer code;
    public CustomException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
        this.message = errorEnum.getMessage();
        this.code = errorEnum.getCode();
    }
}
