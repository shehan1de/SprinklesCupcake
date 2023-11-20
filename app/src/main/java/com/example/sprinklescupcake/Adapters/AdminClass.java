package com.example.sprinklescupcake.Adapters;

public class AdminClass {
    private String AdminId;
    private String AdminName;
    private String Password;

    public AdminClass(String adminId, String adminName, String password) {
        AdminId = adminId;
        AdminName = adminName;
        Password = password;
    }

    public AdminClass() {

    }

    public String getAdminId() {
        return AdminId;
    }

    public void setAdminId(String adminId) {
        AdminId = adminId;
    }

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String adminName) {
        AdminName = adminName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
