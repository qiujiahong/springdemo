package com.nick.spring.service;

import com.nick.spring.mapper.AccountMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

//@Transactional：标记该类的所有方法都已经被事务进行管理了，至于管理属性，不设置的话，都采取默认值
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper mapper;


    @Override
    public void transfer(String from, String to, double money) {
        // 先查询from账户的钱
        double fromMoney = mapper.queryMoney(from);
        // 对from账户进行扣钱操作
        mapper.update(from, fromMoney - money);

        //手动制造异常
//        System.out.println(1/0);
        // 先查询from账户的钱
        double toMoney = mapper.queryMoney(to);
        // 对to账户进行加钱操作
        mapper.update(to, toMoney + money);
    }

}
