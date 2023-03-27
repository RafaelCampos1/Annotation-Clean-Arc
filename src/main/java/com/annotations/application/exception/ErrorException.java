package com.annotations.application.exception;

import com.annotations.domain.enun.ErrorEnum;
import lombok.Getter;

@Getter
public class ErrorException extends RuntimeException{

    private final String message;
    private final Integer code;
    public ErrorException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
        this.message = errorEnum.getMessage();
        this.code = errorEnum.getCode();
    }

}
