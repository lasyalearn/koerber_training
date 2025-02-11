package com.BookApplication.service;

import com.BookApplication.config.SecUser;
import com.BookApplication.entites.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DetailService implements UserDetailsService
{
    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        UserEntity user = userService.findByUsername(username);
        if(user == null)
        {
            throw new UsernameNotFoundException("User not found");
        }
        //return user;
        return new SecUser(user);
    }
}
