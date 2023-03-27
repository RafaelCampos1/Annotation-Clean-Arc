package com.annotations.infrastructure.imp;

import com.annotations.domain.aggregate.User;
import com.annotations.domain.repository.IUser;
import com.annotations.infrastructure.convert.UserConvert;
import com.annotations.infrastructure.jpa.UserRepoJpa;
import com.annotations.infrastructure.persistence.UserEntity;

import java.util.Optional;


public class UserImp implements IUser {

    private final UserRepoJpa JPA;

    public UserImp(UserRepoJpa JPA) {
        this.JPA = JPA;
    }

    @Override
    public void create(User user) {
        JPA.save(UserConvert.convert(user));
    };

    @Override
    public Optional<User> findByUsername(String username) {
        Optional<UserEntity> userEntity = JPA.findUserEntityByUsername(username);
        return userEntity.isEmpty() ? Optional.empty() :
        Optional.of(UserConvert.convert(userEntity.get()));
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<UserEntity> userEntity = JPA.findById(id);
        return userEntity.isEmpty() ? Optional.empty() :
                Optional.of(UserConvert.convert(userEntity.get()));
    }

}
