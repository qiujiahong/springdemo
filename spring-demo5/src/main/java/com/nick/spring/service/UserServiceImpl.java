package com.nick.spring.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;


public class UserServiceImpl implements UserService {

    @Override
    public void saveUser() {
        System.out.println("Ioc 演示 UserServiceImpl:");
    }
}
