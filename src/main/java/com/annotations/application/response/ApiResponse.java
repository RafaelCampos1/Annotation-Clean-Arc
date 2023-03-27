package com.annotations.application.response;

import com.annotations.application.enun.ApiResponseEnum;
import lombok.Getter;

@Getter
public class ApiResponse  {
    Integer code;
    String description;

    public ApiResponse response(ApiResponseEnum apiResponseEnum){
        this.code = apiResponseEnum.getCode();
        this.description = apiResponseEnum.getDescription();
        return this;
    }
}
