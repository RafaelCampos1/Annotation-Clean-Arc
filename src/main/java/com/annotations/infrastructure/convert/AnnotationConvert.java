package com.annotations.infrastructure.convert;

import com.annotations.domain.aggregate.Annotation;
import com.annotations.infrastructure.imp.AnnotationImp;
import com.annotations.infrastructure.persistence.AnnotationEntity;
import com.annotations.infrastructure.persistence.UserEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class AnnotationConvert {

    private final AnnotationImp annotationImp;

    protected AnnotationConvert(AnnotationImp annotationImp) {
        this.annotationImp = annotationImp;
    }

    public static AnnotationEntity convert(Annotation annotation, UserEntity userEntity){
        return new AnnotationEntity(
                annotation.getId(),
                annotation.getTitle(),
                annotation.getContent(),
                userEntity);
    }

    public static Annotation convert(AnnotationEntity annotationEntity){
        return new Annotation(
                annotationEntity.getId(),
                annotationEntity.getTitle(),
                annotationEntity.getContent(),
                UserConvert.convert(annotationEntity.getUserEntity()));
    }

    public static List<Annotation> convert(List<AnnotationEntity> annotationList){
        List<Annotation> annotations = new ArrayList<>();
        annotationList
                .forEach(list -> annotations.add(
                        new Annotation(list.getTitle(),
                                list.getContent(),
                                UserConvert.convert(list.getUserEntity())
                        )));
        return annotations;
    }


}
