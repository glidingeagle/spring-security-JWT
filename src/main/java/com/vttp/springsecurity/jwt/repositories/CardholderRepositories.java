package com.vttp.springsecurity.jwt.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.vttp.springsecurity.jwt.models.Cardholder;

@Repository
public class CardholderRepositories implements Queries {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean existsByUsername (String username) {
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_COUNT_CARDHOLDER_BY_USERNAME, username);

        if(!rs.next())
            return false;
        
        return true;
    }

    public boolean existsByEmail (String email) {
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_COUNT_CARDHOLDER_BY_EMAIL, email);

        if(!rs.next())
            return false;
        
        return true;
    }

    public boolean insertNewUser (Cardholder cardholder) {
        int count = jdbcTemplate.update(SQL_INSERT_NEW_CARDHOLDER, cardholder.getUserId(), cardholder.getUsername(), cardholder.getFirstName(), cardholder.getLastName(), cardholder.getEmail(), cardholder.getPassword());

        return 1 == count;
    }

    public Optional <Cardholder> findByEmail (String email) {
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_GET_CARDHOLDER_INFO_BY_EMAIL, email);

        if(!rs.next())
            return Optional.empty();
        

        Cardholder cardholder = new Cardholder();
        cardholder.setUserId(rs.getString("user_id"));
        cardholder.setUsername(rs.getString("username"));
        cardholder.setFirstName(rs.getString("first_name"));
        cardholder.setLastName(rs.getString("last_name"));
        cardholder.setEmail(rs.getString("email"));
        cardholder.setPassword(rs.getString("password"));
        return Optional.of(cardholder);
    }

    public boolean deleteByUsername (String username) {
        int count = jdbcTemplate.update(SQL_DELETE_CARDHOLDER_INFO_BY_USERNAME, username);

        return 1 == count;
    }
}
