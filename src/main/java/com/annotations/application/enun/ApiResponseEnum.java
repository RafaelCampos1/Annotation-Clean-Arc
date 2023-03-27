package com.annotations.application.enun;

import lombok.Getter;

@Getter
public enum ApiResponseEnum {

    RESPONSE_CREATED("Successfully created :)", 201),
    RESPONSE_UPDATED("Successfully updated :(", 200),
    RESPONSE_DELETED("Successfully deleted :(", 200);

    private final String description;
    private final Integer code;


    ApiResponseEnum(String description, Integer code) {
        this.description = description;
        this.code = code;
    }
}
