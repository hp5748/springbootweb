package com.atguigu.springboot.entity;

public class UserRole {
    private int puid;
    private String role;
    private String state;

    public int getPuid() {
        return puid;
    }

    public void setPuid(int puid) {
        this.puid = puid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "puid=" + puid +
                ", role='" + role + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
