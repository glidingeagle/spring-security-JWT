package com.vttp.springsecurity.jwt.payload;

public class JwtRequest {
    private String email;
    private String password;

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
