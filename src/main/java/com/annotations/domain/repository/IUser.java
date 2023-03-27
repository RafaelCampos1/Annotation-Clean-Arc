package com.annotations.domain.repository;

import com.annotations.domain.aggregate.User;

import java.io.Serializable;
import java.util.Optional;

public interface IUser  extends Serializable{

    static final long serialVersionUID = 1L;
    void create(User user);
    Optional<User> findByUsername(String username);
    Optional<User> findById(Long id);


}
