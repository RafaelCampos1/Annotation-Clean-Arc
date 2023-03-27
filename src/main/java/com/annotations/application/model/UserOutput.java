package com.annotations.application.model;

import com.annotations.domain.valueobject.Username;
import com.fasterxml.jackson.annotation.JsonCreator;

public record UserOutput(Username username) {
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public UserOutput{
    }
}
