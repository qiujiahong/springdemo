package com.nick.spring;

import com.nick.spring.configuration.SpringConfiguration;
import com.nick.spring.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//指定一个新得额运行器，进行
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
//@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestSpringIoC1 {

    @Autowired
    private UserService userService;
    @Test
    public void Test(){
        userService.saveUser();
    }
}
