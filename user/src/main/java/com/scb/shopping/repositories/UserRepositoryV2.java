package com.scb.shopping.repositories;

import com.scb.shopping.model.User;
import com.scb.shopping.repositories.rowmappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryV2 {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserMapper userMapper;

    public User getUserByUsername(String username){
        String sql = "SELECT * FROM user WHERE username = ?";
        try {
            return jdbcTemplate.queryForObject(sql, userMapper, username);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
//    public List<User> searchUser(String name){
//        String sql = "";
//
//        return null;
//    }
    public List<User> searchAll(String name) {

        String sql = "SELECT * FROM `shopping`.`user` WHERE `username` LIKE ?";

        String nameStr= "%" +name.toLowerCase().trim() + "%";

        return jdbcTemplate.query(sql, new Object[]{nameStr}, new  com.scb.shopping.repositories.UserMapper());

    }


}
