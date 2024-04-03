package com.hotellanka.userlogin.service;

import com.hotellanka.userlogin.model.UserEntity;

public interface UserService {
    UserEntity getUserByUsername(String username);
    boolean authenticateUser(String username, String password);
    UserEntity saveUser(UserEntity user);
}
