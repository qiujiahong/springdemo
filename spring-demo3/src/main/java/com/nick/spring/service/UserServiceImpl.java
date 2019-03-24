package com.nick.spring.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;


@Service(value = "userService")
@PropertySource("classpath:data.properties")
public class UserServiceImpl implements UserService {

    @Value("${id}")
    private int id;

    @Override
    public void saveUser() {
        System.out.println("Ioc 演示 UserServiceImpl:"+id);
    }
}
