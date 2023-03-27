package com.annotations.domain.valueobject;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record Title(
        @NotNull(message = "title may not be null")
        @Size(min = 6, message = "title must be more than 5")
        String title)
{

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Title {}


}

