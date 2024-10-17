package com.example.project_javafx;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginFormController {

    @FXML private Button registerButton;
    @FXML private Hyperlink loginLink;
    @FXML private TextField usernameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private TextField passwordField;

    @FXML private Label messageLabel;
    @FXML private Label messageUserName;
    @FXML private Label messagePass;
    @FXML private Button loginButton;

    private UserDAO userDAO = new UserDAO();
    @FXML
    private void initialize() {
        BooleanBinding isFormValid = Bindings.createBooleanBinding(() ->
                        !emailField.getText().isEmpty() &&
                                !passwordField.getText().isEmpty(), // Corrected to check passwordField

                emailField.textProperty(),
                passwordField.textProperty()
        );
        loginButton.disableProperty().bind(isFormValid.not());
    }


    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();
        if (!userDAO.isEmailExists(email)) {
            messageUserName.setText("The account does not exist");
        } else {
            // Nếu tài khoản tồn tại, kiểm tra mật khẩu
            if (userDAO.loginUser(email, password)) {
                messageLabel.setText("Login successful!");

                try {
                    // Tải file FXML của trang cần điều hướng tới
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("food.fxml"));
                    Parent root = loader.load();

                    // Tạo một Stage mới và thiết lập kích thước cửa sổ
                    Stage stage = new Stage();
                    stage.setTitle("Responsive Page");
                    stage.setScene(new Scene(root, 1200, 800)); // Ví dụ kích thước 800x600
                    stage.show();

                    // Đóng cửa sổ đăng nhập hiện tại
                    Stage currentStage = (Stage) emailField.getScene().getWindow();
                    currentStage.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                messagePass.setText("Incorrect password");
            }
        }
    }



    @FXML
    private void switchToRegister() {
        RunLoginForm.setRoot("registerForm");
    }
}


