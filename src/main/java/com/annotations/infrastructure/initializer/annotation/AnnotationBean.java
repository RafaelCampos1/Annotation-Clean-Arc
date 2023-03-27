package com.annotations.infrastructure.initializer.annotation;

import com.annotations.application.usecase.AnnotationUseCase;
import com.annotations.domain.repository.IAnnotation;
import com.annotations.domain.repository.IUser;
import com.annotations.domain.service.annotation.AnnotationServiceImp;
import com.annotations.domain.service.annotation.IAnnotationService;
import com.annotations.infrastructure.imp.AnnotationImp;
import com.annotations.infrastructure.jpa.AnnotationRepoJpa;
import com.annotations.infrastructure.jpa.UserRepoJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationBean {

    @Bean
    public AnnotationUseCase annotationUseCase(IAnnotationService annotationService){
        return new AnnotationUseCase(annotationService);
    }

    @Bean
    public AnnotationServiceImp annotationServiceImp(IAnnotation annotationRepository, IUser userRepository){
        return new AnnotationServiceImp(annotationRepository,userRepository);
    }

    @Bean
    public AnnotationImp annotationImp(AnnotationRepoJpa annotationJPA, UserRepoJpa userJPA){
        return new AnnotationImp(annotationJPA,userJPA);
    }

}
