package com.hr.service;

import com.hr.entity.Users;
import com.hr.repository.UsersDA;
import org.apache.catalina.User;

import java.util.List;

public class UsersService{

    private UsersService(){
    }
    private static final UsersService USERS_SERVICE = new UsersService();

    public static UsersService getInstance() {
        return USERS_SERVICE;
    }

    public void login(Users user) throws Exception {
        try (UsersDA usersDA = new UsersDA()) {
            usersDA.selectOneByUsernameAndPassword(user);
        }
    }

    public void save(Users user) throws Exception{
        try (UsersDA usersDA = new UsersDA()){
            usersDA.insert(user);
            usersDA.commit();
        }
    }

    public void remove(Users user) throws Exception{
        try (UsersDA usersDA = new UsersDA()){
            usersDA.delete(user);
            usersDA.commit();
        }
    }

    public List<Users> findAll() throws Exception {
        try (UsersDA usersDA = new UsersDA()) {
            return usersDA.selectAll();
        }
    }
}
