package com.annotations.infrastructure.advice;


import com.annotations.application.response.ErrorMessage;
import com.annotations.application.response.ErrorObject;
import com.annotations.domain.enun.ErrorEnum;
import com.annotations.domain.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object > handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ErrorObject> errors = getErrors(ex);
        ErrorMessage errorMessage = new ErrorMessage().code(status.value())
                .message(ErrorEnum.INVALID_FIELD.getMessage())
                .timeStamp()
                .errorList(errors);
        return new ResponseEntity<>(errorMessage,
                HttpStatus.BAD_REQUEST);
    }
    private List<ErrorObject> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorObject(
                        error.getDefaultMessage(),
                        error.getField().substring(error.getField().lastIndexOf('.')+1)))
                .collect(Collectors.toList());
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorMessage> badRequest(CustomException customException){
        ErrorMessage errorMessage = new ErrorMessage().code(customException.getCode())
                .message(customException.getMessage())
                .timeStamp();
        return new ResponseEntity<>(errorMessage,
                HttpStatus.BAD_REQUEST);

    }

}
