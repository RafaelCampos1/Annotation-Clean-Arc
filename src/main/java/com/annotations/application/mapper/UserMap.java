package com.annotations.application.mapper;

import com.annotations.application.model.UserInput;
import com.annotations.application.model.UserOutput;
import com.annotations.domain.aggregate.User;
import com.annotations.domain.valueobject.Username;

public abstract class UserMap {

    public static User convert(UserInput userInput){
        return new User(userInput.username().username(),
                userInput.password().password(),
                userInput.name());
    }

    public static UserOutput convert(Username username){
        return new UserOutput(username);
    }

}
