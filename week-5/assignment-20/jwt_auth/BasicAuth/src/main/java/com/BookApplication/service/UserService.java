package com.BookApplication.service;

import com.BookApplication.entites.UserEntity;

import java.util.List;

public interface UserService
{
    public void addUserEntity(UserEntity userEntity);
    public UserEntity findByUsername(String username);
}
