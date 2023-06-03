package org.example.service.impl;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        try {
            userRepository.save(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User load(int userId) {
        User user;
        try {
            user = userRepository.load(userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public User[] loadAll() {
        User[] user;
        try {
            user = userRepository.loadAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public void remove(int userId) {
        try {
            userRepository.remove(userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isUsernameUnavailable(String username) {
        try {
            return userRepository.isUsernameUnavailable(username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean isEmailUnavailable(String email) {
        try {
            return userRepository.isEmailUnavailable(email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isPasswordCurrect(String username, String password) {
        try {
            return userRepository.isPasswordCurrect(username , password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
