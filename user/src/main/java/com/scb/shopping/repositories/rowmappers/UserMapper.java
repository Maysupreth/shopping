package com.scb.shopping.repositories.rowmappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scb.shopping.model.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserMapper implements RowMapper<UserDTO> {

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public UserDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(Long.parseLong(resultSet.getString("id")));
        userDTO.setAddress(resultSet.getString("address"));
        userDTO.setUsername(resultSet.getString("username"));
        userDTO.setPassword(resultSet.getString("password"));
        return userDTO;

    }
}
