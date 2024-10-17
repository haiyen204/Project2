package com.example.project_javafx;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterFormController {

    @FXML private Button registerButton;
    @FXML private Hyperlink loginLink;
    @FXML private TextField usernameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private TextField passwordField;
    @FXML private TextField confirmPasswordField;

    @FXML private Label messageLabel;
    @FXML private Label messageEmail;
    @FXML private Label messagePass;
    @FXML private Label messagePhone;
    @FXML private Label messageConfirmPass;
    @FXML private Label messageUserName;


    private UserDAO userDAO = new UserDAO();

    @FXML
    private void initialize() {

        // Kiểm tra định dạng email và kiểm tra xem email đã tồn tại hay chưa
        emailField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                messageEmail.setText("Invalid email format.");
            } else if (userDAO.isEmailExists(newValue)) {
                messageEmail.setText("Email already exists.");
            } else {
                messageEmail.setText("");
            }
        });
        usernameField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (userDAO.isUserExists(newValue)) {
                messageUserName.setText("Email already exists.");
            } else {
                messageUserName.setText("");
            }
        });

        // Kiểm tra định dạng số điện thoại (10-11 số)
        phoneField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (!newValue.matches("\\d*") || newValue.length() < 10 || newValue.length() > 11) {
                messagePhone.setText("Phone number must be 10 and contain only numbers");
            } else if (userDAO.isPhoneExists(newValue)) {
                messagePhone.setText("Phone Number already exists.");
            }else{
                messagePhone.setText("");
            }
        });

        // Kiểm tra mật khẩu có đủ ký tự không
        passwordField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() < 8 || !newValue.matches(".*[A-Z].*") || !newValue.matches(".*[a-z].*") || !newValue.matches(".*\\d.*") || !newValue.matches(".*[^a-zA-Z0-9].*")) {
                messagePass.setText("Password must be at least 8 characters, including 1 uppercase, 1 lowercase, 1 digit, and 1 special character.");
            } else {
                messagePass.setText("");
            }
        });

        confirmPasswordField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.equals(passwordField.getText())) {
                messageConfirmPass.setText("Passwords do not match.");
            } else {
                messageConfirmPass.setText("");
            }
        });


        BooleanBinding isFormValid = Bindings.createBooleanBinding(() ->

                                emailField.getText().matches("^\\S+@\\S+\\.\\S+$") &&
                                !userDAO.isEmailExists(emailField.getText()) &&
                                phoneField.getText().matches("\\d{10,11}")&&
                                passwordField.getText().length() >= 6 &&
                                passwordField.getText().equals(confirmPasswordField.getText()),

                emailField.textProperty(),
                phoneField.textProperty(),
                passwordField.textProperty(),
                confirmPasswordField.textProperty()
        );
        registerButton.disableProperty().bind(isFormValid.not());
    }
    // Xử lý sự kiện khi nhấn vào nút "Register"
    @FXML
    private void handleRegister() {

        String username = usernameField.getText();

        String email = emailField.getText();
        String phone = phoneField.getText();
        String password = passwordField.getText();

        if (userDAO.registerUser(username, email, phone, password)) {
            messageLabel.setText("Registration successful! You can log in now.");
            RunLoginForm.setRoot("loginForm");
        } else {
            messageLabel.setText("Registration failed. Try again.");
        }
    }



    @FXML
    private void switchToLogin() {
        RunLoginForm.setRoot("loginForm");
    }
}



