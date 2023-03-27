package com.annotations.domain.service.annotation;

import com.annotations.application.model.AnnotationInput;
import com.annotations.domain.aggregate.Annotation;

import java.io.Serializable;
import java.util.List;

public interface IAnnotationService {
    void createAnnotation(String title, String content, Long UserID);
    void deleteAnnotation(Long id);
    void updateAnnotation(String title, String content, Long id);
    List<Annotation> findAnnotation(Long id);

}
