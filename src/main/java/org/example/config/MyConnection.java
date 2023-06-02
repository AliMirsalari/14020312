package org.example.config;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.example.util.Constant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private Connection connection;

    public Connection getConnection(){

        try {
            connection = DriverManager.getConnection(Constant.URL,
                    Constant.DATABASE_USERNAME,
                    Constant.DATABASE_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
