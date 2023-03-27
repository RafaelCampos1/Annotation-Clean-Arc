package com.annotations.infrastructure.persistence;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
public class AnnotationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public AnnotationEntity(String content,String title, UserEntity userEntity) {
        this.content = content;
        this.title = title;
        this.userEntity = userEntity;
    }

    public AnnotationEntity(Long id, String title, String content, UserEntity userEntity) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userEntity = userEntity;
    }

    public AnnotationEntity() {

    }

}
