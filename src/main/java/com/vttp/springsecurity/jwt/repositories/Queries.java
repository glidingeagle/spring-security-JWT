package com.vttp.springsecurity.jwt.repositories;

public interface Queries {
    public static final String SQL_COUNT_CARDHOLDER_BY_USERNAME = "select * from cardholders where username = ?";

    public static final String SQL_COUNT_CARDHOLDER_BY_EMAIL = "select * from cardholders where email = ?";

    public static final String SQL_INSERT_NEW_CARDHOLDER = "insert into cardholders (user_id, username, first_name, last_name, email, password) values (?, ?, ?, ?, ?, ?)";
    
    public static final String SQL_GET_CARDHOLDER_INFO_BY_EMAIL = "select * from cardholders where email = ?";
}
