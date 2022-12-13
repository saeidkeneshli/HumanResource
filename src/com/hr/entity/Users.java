/*
This entity created for Login action
The hr system has 3 kind of user with different level of access: 1.admin 2.manager 3.employee
 */

package com.hr.entity;

public class Users {
    private long id;
    private String username, password, role_name;

    public Users() {
    }

    public Users(long id, String username, String password, String user_role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role_name = user_role;
    }

    public Users(String username, String password, String user_role) {
        this.username = username;
        this.password = password;
        this.role_name = user_role;
    }

    public long getId() {
        return id;
    }

    public Users setId(long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Users setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Users setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole_name() {
        return role_name;
    }

    public Users setRole_name(String role_name) {
        this.role_name = role_name;
        return this;
    }
}
