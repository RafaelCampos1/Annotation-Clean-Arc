package com.annotations.domain.service.annotation;

import com.annotations.domain.aggregate.Annotation;
import com.annotations.domain.aggregate.User;
import com.annotations.domain.enun.ErrorEnum;
import com.annotations.domain.exception.CustomException;
import com.annotations.domain.repository.IAnnotation;
import com.annotations.domain.repository.IUser;

import java.util.List;
import java.util.Optional;

public class AnnotationServiceImp implements IAnnotationService {

    private final IAnnotation iAnnotation;
    private final IUser iUser;

    public AnnotationServiceImp(IAnnotation iAnnotation, IUser iUser) {
        this.iAnnotation = iAnnotation;
        this.iUser = iUser;
    }

    public void createAnnotation(String title, String Content, Long UserID){
        Optional<User> user = iUser.findById(UserID);
        if(user.isEmpty())
            throw new CustomException(ErrorEnum.PEOPLE_NOT_FOUND);
        Annotation annotation =  new Annotation(title, Content, user.get());
        iAnnotation.create(annotation);
    }

    public void deleteAnnotation(Long id){
        Optional<Annotation> annotation = iAnnotation.findById(id);
        if(annotation.isEmpty())
            throw new CustomException(ErrorEnum.ANNOTATION_NOT_FOUND);
        iAnnotation.delete(annotation.get());
    }


    public void updateAnnotation(String title, String content, Long id){
        Optional<Annotation> annotation = iAnnotation.findById(id);
        if(annotation.isEmpty())
            throw new CustomException(ErrorEnum.ANNOTATION_NOT_FOUND);
        if(!title.isEmpty())
            annotation.get().setTitle(title);
        if(!title.isEmpty())
            annotation.get().setContent(content);

        iAnnotation.update(annotation.get());
    }

    public List<Annotation> findAnnotation(Long id){
        return iAnnotation.findAllByUserId(id);
    };
}
