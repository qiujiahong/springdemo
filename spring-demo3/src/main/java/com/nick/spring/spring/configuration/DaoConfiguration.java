package com.nick.spring.spring.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfiguration {

    public DaoConfiguration(){
        System.out.println("Dao configuration初始化");
    }
}
