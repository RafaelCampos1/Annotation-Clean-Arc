package com.annotations.application.model;

import com.annotations.domain.valueobject.Content;
import com.annotations.domain.valueobject.Title;

import javax.validation.Valid;

public record AnnotationInput(
        @Valid
        Title title,
        Content content,
        Long userId) {
}
