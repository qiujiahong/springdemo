package com.nick.spring.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Override
    public void saveUser() {
        System.out.println("添加用户");
    }
}
