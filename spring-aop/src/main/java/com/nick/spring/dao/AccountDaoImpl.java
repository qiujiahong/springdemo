package com.nick.spring.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    // JDBC操作
    // Mybatis操作
    // JdbcTemplate操作
    // @Resource
    // private JdbcTemplate jdbcTemplate;

    @Override
    public void update(String name, double money) {
        Object[] args = { money, name };
        // jdbcTemplate.update("UPDATE account SET money = ? WHERE name = ? ", args);
        this.getJdbcTemplate().update("UPDATE account SET money = ? WHERE name = ? ", args);
    }

    @Override
    public double queryMoney(String name) {
        // Double money = jdbcTemplate.queryForObject("SELECT money FROM account WHERE
        // name = ?", new DoubleMapper(),
        // name);

        Double money = this.getJdbcTemplate().queryForObject("SELECT money FROM account WHERE name = ?",
                new DoubleMapper(), name);
        return money;
    }
}


class DoubleMapper implements RowMapper<Double> {

    @Override
    public Double mapRow(ResultSet rs, int rowNum) throws SQLException {
        return rs.getDouble("money");
    }

}