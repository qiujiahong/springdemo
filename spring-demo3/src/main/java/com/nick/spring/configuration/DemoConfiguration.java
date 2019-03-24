package com.nick.spring.configuration;

import com.nick.spring.service.UserService;
import com.nick.spring.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfiguration {

    @Value("${id}")
    private int id;
    @Value("${name}")
    private String name;


    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }
}
