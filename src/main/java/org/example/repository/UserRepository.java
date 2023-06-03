package org.example.repository;

import org.example.model.User;

import java.sql.SQLException;

public interface UserRepository{
    void save(User user) throws SQLException;
    User load(int userId) throws SQLException;
    User[] loadAll() throws SQLException;
    void remove(int userId) throws SQLException;
    boolean isUsernameUnavailable(String username) throws SQLException;
    boolean isEmailUnavailable(String email) throws SQLException;

    public boolean isPasswordCurrect (String Username , String password)throws SQLException;



}
