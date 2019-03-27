package com.nick.spring.spring.service;

public class UserServiceImpl implements UserService {
    //有参构造
    public UserServiceImpl(int id){
        System.out.println(id);
    }

    //有参构造
    public UserServiceImpl(){
        System.out.println("无参构造");
    }

    @Override
    public void saveUser() {
        System.out.println("Ioc 演示 UserServiceImpl");
    }
}
