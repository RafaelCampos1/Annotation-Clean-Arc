package com.annotations.domain.service.user;

import com.annotations.domain.aggregate.User;
import com.annotations.domain.enun.ErrorEnum;
import com.annotations.domain.exception.CustomException;
import com.annotations.domain.repository.IUser;


public class UserServiceImp implements  IUserService {

    static final long serialVersionUID = 1L;

    private final IUser iUser;

    public UserServiceImp(IUser iUser) {
        this.iUser = iUser;
    }

    public void register(String username, String password, String name){
        if(iUser.findByUsername(username).isPresent())
            throw new CustomException(ErrorEnum.USERNAME_ALREADY_EXISTS);
      iUser.create(new User(username,password,name));
    }

}
