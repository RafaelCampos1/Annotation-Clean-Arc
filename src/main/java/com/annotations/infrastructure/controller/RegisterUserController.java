package com.annotations.infrastructure.controller;

import com.annotations.application.ApiConfiguration;
import com.annotations.application.enun.ApiResponseEnum;
import com.annotations.application.model.UserInput;
import com.annotations.application.response.ApiResponse;
import com.annotations.application.usecase.UserUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j

@RestController
@RequestMapping(ApiConfiguration.API_VERSION + ApiConfiguration.REGISTER_USER)
public class RegisterUserController {
    private final UserUseCase userUseCase;

    public RegisterUserController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }


    @PostMapping
    public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody UserInput userInput){
        userUseCase.register(userInput);
        return new ResponseEntity<>(new ApiResponse().response(ApiResponseEnum.RESPONSE_CREATED),HttpStatus.CREATED);
    }


}
