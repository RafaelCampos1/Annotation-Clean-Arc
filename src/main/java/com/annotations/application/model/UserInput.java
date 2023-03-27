package com.annotations.application.model;

import com.annotations.domain.valueobject.Password;
import com.annotations.domain.valueobject.Username;

import javax.validation.Valid;

public record UserInput(
        @Valid
        Username username,
        @Valid
        Password password,

        @Valid
        String name)
{

    public UserInput{}
}
