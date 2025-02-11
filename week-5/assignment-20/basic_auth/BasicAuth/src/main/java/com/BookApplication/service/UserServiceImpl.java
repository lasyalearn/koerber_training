package com.BookApplication.service;

import com.BookApplication.dao.UserRepo;
import com.BookApplication.entites.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepo userRepo;

    @Override
    public void addUserEntity(UserEntity userEntity)
    {
        userRepo.save(userEntity);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return  userRepo.findByUsername(username);
    }
}
