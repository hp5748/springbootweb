package com.atguigu.springboot.entity;

public class UserGroup {
    private int puid;
    private String group_name;
    private String state;

    public int getPuid() {
        return puid;
    }

    public void setPuid(int puid) {
        this.puid = puid;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "UserGroup{" +
                "puid=" + puid +
                ", group_name='" + group_name + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
