package com.somoo.organizer.ui.login.controller;

import com.somoo.organizer.service.impl.UserRepositoryServiceImpl;
import com.somoo.organizer.user.User;

import java.util.Optional;

public class LoginController {

    private final UserRepositoryServiceImpl userRepositoryServiceImpl;

    public LoginController(UserRepositoryServiceImpl userRepositoryServiceImpl){
        this.userRepositoryServiceImpl = userRepositoryServiceImpl;
    }

    public boolean authenticate(String login, String password){
        Optional<User> userOpt = userRepositoryServiceImpl.read(login);
        if(userOpt.isPresent()){
            return userOpt.get().getPassWord().equals(password);
        }
        return false;
    }
}
