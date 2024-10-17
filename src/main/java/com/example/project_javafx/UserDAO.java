package com.example.project_javafx;

import com.example.project_javafx.dao.JDBCConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public boolean isEmailExists(String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        try (Connection connection = JDBCConnect.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // If email exists
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to check if a phone number already exists
    public boolean isPhoneExists(String phoneNumber) {
        String query = "SELECT * FROM users WHERE phone_number = ?";
        try (Connection connection = JDBCConnect.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, phoneNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // If phone number exists
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to check if a username already exists
    public boolean isUserExists(String userName) {
        String query = "SELECT * FROM users WHERE user_name = ?";
        try (Connection connection = JDBCConnect.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // If username exists
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to register a new user
    public boolean registerUser(String userName, String email, String phoneNumber, String password) {
        String query = "INSERT INTO users (user_name, email, phone_number, password) VALUES (?, ?, ?, ?)";
        try (Connection connection = JDBCConnect.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.setString(4, password);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to authenticate a user during login
    public boolean loginUser(String email, String password) {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection connection = JDBCConnect.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password); // In production, use a hashed password
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // If user exists
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}



