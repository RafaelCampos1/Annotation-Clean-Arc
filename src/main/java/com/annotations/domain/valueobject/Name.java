package com.annotations.domain.valueobject;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Slf4j
public record Name(
        @NotNull(message = "Name may not be null")
        @Size(min = 6, message = "Name must be more than 5")
        @NotBlank(message = "Name must be more than 5")
        String name)
{
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Name{}
}
