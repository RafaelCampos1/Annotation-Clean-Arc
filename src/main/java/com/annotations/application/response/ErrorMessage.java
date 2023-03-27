package com.annotations.application.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.List;

@Getter
public class ErrorMessage {
    private String timeStamp;

    private String message;
    private Integer code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ErrorObject> errorObjectList;

    public ErrorMessage errorList(List<ErrorObject> errorObjectList) {
        this.errorObjectList = errorObjectList;
        return this;
    }
    public ErrorMessage timeStamp() {
        this.timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
        return this;
    }

    public ErrorMessage code(Integer code){
        this.code = code;
        return this;
    }

    public ErrorMessage message(String message){
        this.message = message;
        return this;
    }
}
