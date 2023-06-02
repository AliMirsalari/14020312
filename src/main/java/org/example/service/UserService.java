package org.example.service;

import org.example.model.User;

public interface UserService {
    void save(User user);
    User load(int userId);
    User[] loadAll();

    void remove(int userId);
    boolean isUsernameAvailable(String username);
    boolean isEmailAvailable(String email);
}
