package com.annotations.domain.aggregate;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class User {

    private Long id;
    private String username;
    private String password;

    private String name;


    private List<Annotation> annotations;

    public User(Long id, String username, String password, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public User( String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }


    public User( String username) {
        this.username = username;
    }

    public User() {

    }


}
