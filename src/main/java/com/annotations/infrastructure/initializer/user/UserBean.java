package com.annotations.infrastructure.initializer.user;

import com.annotations.application.usecase.UserUseCase;
import com.annotations.domain.repository.IUser;
import com.annotations.domain.service.user.IUserService;
import com.annotations.domain.service.user.UserServiceImp;
import com.annotations.infrastructure.imp.UserImp;
import com.annotations.infrastructure.jpa.UserRepoJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBean {
    @Bean
    public UserServiceImp userServiceImp(IUser iUser ){
        return new UserServiceImp(iUser);
    }

    @Bean
    public UserUseCase userUseCase(IUserService iUserService ){
        return new UserUseCase(iUserService);
    }

    @Bean public UserImp userImp(UserRepoJpa userRepoJpa){
        return new UserImp(userRepoJpa);
    }


}
