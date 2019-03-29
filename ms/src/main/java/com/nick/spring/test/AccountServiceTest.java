package com.nick.spring.test;

import com.nick.spring.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/application*.xml"})
public class AccountServiceTest {

    @Resource
    private AccountService service;

    @Test
    public void testTransfer(){
        service.transfer("老公","老婆",10);
    }
}
