package com.atguigu.springboot.entity;

public class UserInfo{

    private int puid;
    private String user_name;
    private String account;
    private String password;
    private String effective;
    private int group_id;
    private int role_id;
    private UserRole userRole;
    private UserGroup userGroup;
    private RoleAuthority roleAuthority;

    public int getPuid() {
        return puid;
    }

    public void setPuid(int puid) {
        this.puid = puid;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEffective() {
        return effective;
    }

    public void setEffective(String effective) {
        this.effective = effective;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public RoleAuthority getRoleAuthority() {
        return roleAuthority;
    }

    public void setRoleAuthority(RoleAuthority roleAuthority) {
        this.roleAuthority = roleAuthority;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "puid=" + puid +
                ", user_name='" + user_name + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", effective='" + effective + '\'' +
                ", group_id=" + group_id +
                ", role_id=" + role_id +
                ", userRole=" + userRole +
                ", userGroup=" + userGroup +
                ", roleAuthority=" + roleAuthority +
                '}';
    }
}
