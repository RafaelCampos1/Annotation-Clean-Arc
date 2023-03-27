package com.annotations.infrastructure.imp;

import com.annotations.domain.aggregate.Annotation;
import com.annotations.domain.repository.IAnnotation;
import com.annotations.infrastructure.convert.AnnotationConvert;
import com.annotations.infrastructure.jpa.AnnotationRepoJpa;
import com.annotations.infrastructure.jpa.UserRepoJpa;
import com.annotations.infrastructure.persistence.AnnotationEntity;
import com.annotations.infrastructure.persistence.UserEntity;

import java.util.List;
import java.util.Optional;

public class AnnotationImp implements IAnnotation {

    private final AnnotationRepoJpa annotationJPA;
    private final UserRepoJpa userJPA;

    public AnnotationImp(AnnotationRepoJpa annotationJPA, UserRepoJpa userRepository) {
        this.annotationJPA = annotationJPA;
        this.userJPA = userRepository;
    }

    public Optional<UserEntity> userEntity(Long id){
       return userJPA.findById(id);
    }

    @Override
    public List<Annotation> findAllByUserId(Long id) {
        List<AnnotationEntity> annotationEntity = annotationJPA.findAllByUserEntityId(id);
        return AnnotationConvert.convert(annotationEntity);
    }

    @Override
    public Optional<Annotation> findById(Long id) {
        Optional<AnnotationEntity> annotationEntity = annotationJPA.findById(id);
        return annotationEntity.isEmpty() ? Optional.empty() :
                Optional.of(AnnotationConvert.convert(annotationEntity.get()));
    }

    @Override
    public void delete(Annotation annotation) {
        annotationJPA.delete(AnnotationConvert.convert(annotation,userEntity(annotation.getUser().getId()).get()));
    }

    @Override
    public void update(Annotation annotation) {
        annotationJPA.save(AnnotationConvert.convert(annotation,userEntity(annotation.getUser().getId()).get()));
    }

    @Override
    public void create(Annotation annotation) {
        annotationJPA.save(AnnotationConvert.convert(annotation,userEntity(annotation.getUser().getId()).get()));
    }

    @Override
    public List<Annotation> findAll() {
        return null;
    }

    @Override
    public Annotation findByContent(String content) {
        return null;
    }
}
