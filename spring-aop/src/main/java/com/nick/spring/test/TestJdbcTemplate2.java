package com.nick.spring.test;

import com.nick.spring.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// 使用spring 管理链接,简化 JdbcTemplate的使用
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class TestJdbcTemplate2 {

    @Autowired  //按类型注入
    private JdbcTemplate jdbcTemplate;
//    @Resource
//    private JdbcTemplate template;

    @Test
    public void test() {
        // 完成数据的添加
        jdbcTemplate.update("insert into account values (null,?,?)", "测试12", 10000);
    }

    @Test
    public void test2() {
        // 第一个参数：要执行的SQL语句
        // 第二个参数：结果映射处理器（RowMapper）
        // 第三个参数：SQL语句中的入参
        List<Account> aList = jdbcTemplate.query("SELECT * FROM account", new MyBeanMapper(), null);
        System.out.println(aList);
    }
}
/**
 * 结果映射器
 * @author think
 *
 */
class MyBeanMapper implements RowMapper {

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getDouble("money"));
        return account;
    }
}
