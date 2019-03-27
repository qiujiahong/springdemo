package com.nick.spring.spring.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//配置类
@Configuration
@ComponentScan(basePackages = "com.nick.spring.service")
@Import(DaoConfiguration.class)
public class SpringConfiguration {
    public SpringConfiguration(){
        System.out.println("容器初始化...");
    }
    //纯注解方式之IOC配置通过@Bean注,相当于spring配置文件中的bean标签
//    @Bean(value = "userService")
//    @Bean
//    public UserService userService(){
//        return new UserServiceImpl();
//    }
}
