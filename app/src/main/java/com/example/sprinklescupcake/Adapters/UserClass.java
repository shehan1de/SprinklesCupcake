package com.example.sprinklescupcake.Adapters;

public class UserClass {
    private String UserId;
    private String UserName;
    private String Password;

    public UserClass(String userId, String userName, String password) {
        UserId = userId;
        UserName = userName;
        Password = password;
    }

    public UserClass() {

    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}


