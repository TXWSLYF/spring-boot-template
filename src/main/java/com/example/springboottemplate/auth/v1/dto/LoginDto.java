package com.example.springboottemplate.auth.v1.dto;

public class LoginDto {
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public LoginDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    private String userName;
    private String password;
}
