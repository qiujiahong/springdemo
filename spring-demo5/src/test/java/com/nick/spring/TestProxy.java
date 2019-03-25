package com.nick.spring;

import com.nick.spring.service.UserService;
import com.nick.spring.service.UserServiceImpl;
import com.nick.spring.utils.MyProxyUtils;
import org.junit.Test;

public class TestProxy {


    @Test
    public void testJdkProxy(){
        UserService service = new UserServiceImpl();
        UserService  proxy =  MyProxyUtils.getProxy(service);

        service.saveUser();
        System.out.println("===================");
        proxy.saveUser();
    }


    @Test
    public void testCgLibProxy(){
        UserService service = new UserServiceImpl();
        UserService  proxy =  MyProxyUtils.getProxyByCgLib(service);

        service.saveUser();
        System.out.println("===================");
        proxy.saveUser();
    }
}
