package com.annotations.application.usecase;

import com.annotations.application.model.UserInput;
import com.annotations.domain.service.user.IUserService;
public class UserUseCase {
    private final IUserService iUserService;

    public UserUseCase(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    public void register(UserInput userInput){
        iUserService.register(
                userInput.username().username(),
                userInput.password().password(),
                userInput.name());
    }
}
