package com.offcn.pojo;

public class Users {
    private Integer id;

    private String email;

    private String username;

    private String password;

    private Byte userRoleType;

    private Byte isEmailAuth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getUserRoleType() {
        return userRoleType;
    }

    public void setUserRoleType(Byte userRoleType) {
        this.userRoleType = userRoleType;
    }

    public Byte getIsEmailAuth() {
        return isEmailAuth;
    }

    public void setIsEmailAuth(Byte isEmailAuth) {
        this.isEmailAuth = isEmailAuth;
    }
}