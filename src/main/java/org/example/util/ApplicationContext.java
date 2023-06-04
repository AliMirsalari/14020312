package org.example.util;

import org.example.config.MyConnection;
import org.example.repository.UserRepository;
import org.example.repository.impl.UserRepositoryImpl;
import org.example.service.UserService;
import org.example.service.impl.UserServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class ApplicationContext {
    private static Connection connection;
    private static UserRepository userRepository;
    private static UserService userService;

    static {
            userRepository = new UserRepositoryImpl(new MyConnection());
            userService = new UserServiceImpl(userRepository);
    }

    public static UserService getUserService() {
        return userService;
    }
}
