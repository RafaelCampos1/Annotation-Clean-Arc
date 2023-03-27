package com.annotations.domain.enun;

import lombok.Getter;

@Getter
public enum ErrorEnum {

    INVALID_FIELD("Filling error", 400),
    ANNOTATION_NOT_FOUND("Annotation not found", 400),
    INVALID_USERNAME("Invalid username", 400),
    INVALID_PASSWORD("Invalid Password", 400),
    NON_EXISTING_USERNAME("Non-existing Username", 400),
    INCORRECT_PASSWORD("Incorrect Password", 400),
    USERNAME_ALREADY_EXISTS("Username already exists!", 400),
    PEOPLE_NOT_FOUND("Person not fount!", 400);

    private final String message;
    private final Integer code;

    ErrorEnum(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
}
