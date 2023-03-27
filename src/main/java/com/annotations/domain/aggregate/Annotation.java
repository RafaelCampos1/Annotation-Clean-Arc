package com.annotations.domain.aggregate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class Annotation implements java.io.Serializable{

    private Long id;

    private String title;
    private String content;

    private User user;

    public Annotation(String content,String title, User user) {
        this.content = content;
        this.title = title;
        this.user = user;
    }

    public Annotation(Long id, String title, String content, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public Annotation() {

    }
}
