package com.nick.spring;

import com.nick.spring.service.UserService;
import com.nick.spring.service.UserServiceImpl;
import com.nick.spring.utils.MyProxyUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestProxy {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        userService.saveUser();
    }

}
