package com.annotations.domain.valueobject;

import com.fasterxml.jackson.annotation.JsonCreator;

public record Content(
        String content) {
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Content{}
}
