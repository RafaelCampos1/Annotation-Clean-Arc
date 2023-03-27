package com.annotations.application.usecase;

import com.annotations.application.mapper.AnnotationMap;
import com.annotations.application.model.AnnotationInput;
import com.annotations.application.model.AnnotationOutPut;
import com.annotations.domain.aggregate.Annotation;
import com.annotations.domain.service.annotation.IAnnotationService;

import java.util.List;
public class AnnotationUseCase {

    private final IAnnotationService iAnnotationService;

    public AnnotationUseCase(IAnnotationService iAnnotationService) {
        this.iAnnotationService = iAnnotationService;
    }

    public void createAnnotation (AnnotationInput annotationInput){
        iAnnotationService.createAnnotation(
                annotationInput.title().title(),
                annotationInput.content().content(),
                annotationInput.userId());

    }

    public List<AnnotationOutPut> findAnnotation (Long id){
        List<Annotation> annotations = iAnnotationService.findAnnotation(id);
        return AnnotationMap.convert(annotations);
    }

    public void deleteAnnotation (Long id){
        iAnnotationService.deleteAnnotation(id);
    }
    public void updateAnnotation (AnnotationInput annotationInput,Long id){
        iAnnotationService.updateAnnotation(
                annotationInput.title().title(),
                annotationInput.content().content(),
                id);

    }
}
