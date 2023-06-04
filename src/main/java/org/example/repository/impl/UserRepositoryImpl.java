package org.example.repository.impl;

import org.example.config.MyConnection;
import org.example.model.User;
import org.example.repository.UserRepository;

import java.sql.*;

public class UserRepositoryImpl implements UserRepository {

    private MyConnection myConnection;


    public UserRepositoryImpl(MyConnection connection) {
        this.myConnection = connection;
    }

    @Override
    public void save(User user) throws SQLException {
        Connection connection = myConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users_tb(nat_code, first_name, last_name, username, password, email) values (?,?,?,?,?,?) returning user_id;");
        preparedStatement.setString(1, user.getNatCode());
        preparedStatement.setString(2, user.getFirstName());
        preparedStatement.setString(3, user.getLastName());
        preparedStatement.setString(4, user.getUsername());
        preparedStatement.setString(5, user.getPassword());
        preparedStatement.setString(6, user.getEmail());
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();
        if (resultSet.next()) {
            int id = resultSet.getInt("user_id");
        }
        preparedStatement.close();
        connection.close();


    }

    @Override
    public User load(int userId) throws SQLException {
        Connection connection = myConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users_tb WHERE user_id = ?;");
        preparedStatement.setInt(1, userId);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();

        User user = null;
        if (resultSet.next()) {
            user = new User(resultSet.getString("nat_code"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("email"));
        }
        preparedStatement.close();
        connection.close();
        return user;
    }

    @Override
    public User[] loadAll() throws SQLException {
        Connection connection = myConnection.getConnection();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        statement.execute("SELECT * FROM users_tb ;");
        ResultSet resultSet = statement.getResultSet();


        resultSet.last();
        int arrayLength = resultSet.getRow();
        resultSet.beforeFirst();
        User[] user = new User[arrayLength];
        int i = 0;
        while (resultSet.next()) {

            user[i] = new User(resultSet.getString("nat_code"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("email"));
            i++;
        }
        statement.close();
        connection.close();
        return user;
    }

    @Override
    public void remove(int userId) throws SQLException {
        Connection connection = myConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users_tb WHERE user_id =?;");
        preparedStatement.setInt(1, userId);
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    @Override
    public boolean isUsernameUnavailable(String username) throws SQLException {
        Connection connection = myConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT username FROM users_tb WHERE username = ?;");
        preparedStatement.setString(1, username);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();

        boolean result  = false;


        if (resultSet.next()) {
            result = false;
        }else {
            result =  true;
        }

        preparedStatement.close();
        connection.close();
        return result;

    }

    @Override
    public boolean isEmailUnavailable(String email) throws SQLException {
        Connection connection = myConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT email FROM users_tb WHERE email = ?;");
        preparedStatement.setString(1, email);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();

        boolean result  = false;


        if (resultSet.next()) {
            result = false;
        }else {
            result =  true;
        }

        preparedStatement.close();
        connection.close();
        return result;
    }

    @Override
    public boolean isPasswordCurrect (String username , String password) throws SQLException{
        Connection connection = myConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM users_tb WHERE username = ? AND password = ?;");
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();

        boolean result  = false;

        if (resultSet.next() && resultSet.getInt(1) > 0) {
            connection.close();
            return true;
        } else {
            connection.close();
            return false;
        }
    }
}
