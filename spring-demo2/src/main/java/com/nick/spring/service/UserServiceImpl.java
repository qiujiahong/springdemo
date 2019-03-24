package com.nick.spring.service;


import org.springframework.stereotype.Component;

//在需要
// value该类在容器中的唯一标识 ,如果不写value默认的id就是首字母小写
@Component(value = "userService")
public class UserServiceImpl implements UserService {
    @Override
    public void saveUser() {
        System.out.println("Ioc 演示 UserServiceImpl");
    }
}
