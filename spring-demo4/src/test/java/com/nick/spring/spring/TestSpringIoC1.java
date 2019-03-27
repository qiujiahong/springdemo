package com.nick.spring.spring;

import com.nick.spring.spring.configuration.SpringConfiguration;
import com.nick.spring.spring.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


// @RunWith junit自生的注解，他的作用可以指定一个新的运行器
// SpringJUnit4ClassRunner spring提供单元测试运行器
// 指定一个新得额运行器，进行
@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration： SpringJUnit4ClassRunner运行器需要的上下文
// classes： 注解方式，读取配置类
// locations： 配置方式，读取配置文件
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
