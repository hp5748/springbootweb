package com.atguigu.springboot.entity;

public class RoleAuthority {
    private int puid;
    private String function_flag;
    private int role_id;
    private String description;
    private String effective;

    public int getPuid() {
        return puid;
    }

    public void setPuid(int puid) {
        this.puid = puid;
    }

    public String getFunction_flag() {
        return function_flag;
    }

    public void setFunction_flag(String function_flag) {
        this.function_flag = function_flag;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEffective() {
        return effective;
    }

    public void setEffective(String effective) {
        this.effective = effective;
    }

    @Override
    public String toString() {
        return "RoleAuthority{" +
                "puid='" + puid + '\'' +
                ", function_flag='" + function_flag + '\'' +
                ", role_id=" + role_id +
                ", description='" + description + '\'' +
                ", effective='" + effective + '\'' +
                '}';
    }
}
