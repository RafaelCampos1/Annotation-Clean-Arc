package com.annotations.domain.repository;

import com.annotations.domain.aggregate.Annotation;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IAnnotation{
    List<Annotation> findAllByUserId(Long id);
    Optional<Annotation> findById(Long id);
    void delete(Annotation annotation);
    void update(Annotation annotation);
    void create (Annotation annotation);
    List<Annotation> findAll();
    Annotation findByContent(String content);
}
