package com.hr.repository;


import com.hr.common.InvalidUsernameOrPassword;
import com.hr.common.JDBC;
import com.hr.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsersDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public UsersDA() throws Exception {
        connection = JDBC.getConnection();
    }

    public void insert(Users user) throws Exception {
        preparedStatement = connection.prepareStatement("select hr_users_seq.nextval id from dual");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        user.setId(resultSet.getLong("id"));

        preparedStatement = connection.prepareStatement("insert into hr_users values (?,?,?,?)");
        preparedStatement.setLong(1, user.getId());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setString(4, user.getRole_name());
        preparedStatement.executeUpdate();
    }

    public void delete(Users user) throws Exception {
        preparedStatement = connection.prepareStatement("delete hr_users where id=?");
        preparedStatement.setLong(1, user.getId());
        preparedStatement.executeUpdate();
    }

    public void selectOneByUsernameAndPassword(Users user) throws Exception {
        preparedStatement = connection.prepareStatement("select * from hr_users where lower(username)=lower(?) and password=?");
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            user.setId(resultSet.getLong("id"));
            user.setRole_name(resultSet.getString("role_name"));
        } else {
            throw new InvalidUsernameOrPassword();
        }
    }

    public List<Users> selectAll() throws Exception {
        preparedStatement = connection.prepareStatement("select * from hr_users");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Users> usersList = new ArrayList<>();
        while (resultSet.next()) {
            Users user = new Users()
                    .setUsername(resultSet.getString("username"))
                    .setRole_name(resultSet.getString("role_name"));
            usersList.add(user);
        }
        return usersList;
    }

    public void commit() throws Exception {
        connection.commit();
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
