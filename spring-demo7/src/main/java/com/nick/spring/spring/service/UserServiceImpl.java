package com.nick.spring.spring.service;


import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Override
    public void saveUser() {
        System.out.println("添加用户");
    }
}
