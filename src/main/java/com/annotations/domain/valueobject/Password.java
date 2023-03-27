package com.annotations.domain.valueobject;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Slf4j
public record Password(
        @NotNull(message = "password may not be null")
        @Size(min = 6, message = "password must be more than 5")
        String password)
{

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Password {}
}
