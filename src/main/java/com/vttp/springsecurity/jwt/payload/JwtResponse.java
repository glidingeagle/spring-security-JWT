package com.vttp.springsecurity.jwt.payload;

public class JwtResponse {
    private String token;
    private String userId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;

    public JwtResponse(String token) {
        this.token = token;
    }

    public JwtResponse(String token, String userId, String username, String firstName, String lastName, String email) {
        this.token = token;
        this.userId = userId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void setToken (String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
