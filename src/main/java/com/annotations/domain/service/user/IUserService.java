package com.annotations.domain.service.user;

import java.io.Serializable;

public interface IUserService extends Serializable {

    void register (String username, String password, String name);
}
