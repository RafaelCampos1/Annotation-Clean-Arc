package com.annotations.infrastructure.convert;

import com.annotations.domain.aggregate.User;
import com.annotations.infrastructure.persistence.UserEntity;
import org.springframework.stereotype.Service;

@Service
public abstract class UserConvert {

    public static User convert(UserEntity userEntity){
        return new User(userEntity.getId(),userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getName());
    }


    public static UserEntity convert(User user){
        return new UserEntity(user.getId(),user.getUsername(),
                user.getPassword(),
                user.getName());
    }

    public static UserEntity convert(String username){
        return new UserEntity(username);
    }

}
