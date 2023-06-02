package org.example.repository;

import org.example.model.User;

import java.sql.SQLException;

public interface UserRepository{
    void save(User user) throws SQLException;
    User load(int userId) throws SQLException;
    User[] loadAll() throws SQLException;
    void remove(int userId) throws SQLException;
    boolean isUsernameAvailable(String username) throws SQLException;
    boolean isEmailAvailable(String email) throws SQLException;



}
