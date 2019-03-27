package com.nick.spring.spring;

import com.nick.spring.spring.configuration.SpringConfiguration;
import com.nick.spring.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpringIoC {
    @Test
    public void Test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService service1 = context.getBean(UserService.class);
        service1.saveUser();
        UserService service2 = (UserService)context.getBean("userService");
        service2.saveUser();
    }
}
