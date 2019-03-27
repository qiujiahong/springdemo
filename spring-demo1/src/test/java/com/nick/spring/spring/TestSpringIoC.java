package com.nick.spring.spring;

import com.nick.spring.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringIoC {
    @Test
    public void Test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //根据类型从容器中获取实例
        UserService service1 = context.getBean(UserService.class);
        //根据bean的id获取
        UserService service2 = (UserService) context.getBean("userService");
        service1.saveUser();
        service2.saveUser();
    }
}
