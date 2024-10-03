package accout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterForm extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Thêm hình ảnh logo (nếu cần)
        Image logoImage = new Image("D:\\project2\\src\\main\\java\\Image");
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitWidth(150);  // Đặt chiều rộng ảnh
        logoImageView.setFitHeight(100); // Đặt chiều cao ảnh

        Label logo = new Label();
        logo.setGraphic(logoImageView);  // Thêm hình ảnh vào Label

        Label registerLabel = new Label("Register");
        registerLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Tạo các trường nhập liệu
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        TextField phoneField = new TextField();
        phoneField.setPromptText("Phone");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        PasswordField repeatPasswordField = new PasswordField();
        repeatPasswordField.setPromptText("Repeat Password");

        // Nút đăng ký
        Button registerButton = new Button("Register");

        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        // Liên kết cho người đã có tài khoản
        Hyperlink alreadyAccountLink = new Hyperlink("Already have an account?");
        alreadyAccountLink.setOnAction(event -> {
            // Chuyển đến trang đăng nhập
            LoginForm loginForm = new LoginForm();
            loginForm.start(primaryStage);
        });

        registerButton.setOnAction(e -> {
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();
            String password = passwordField.getText().trim();
            String repeatPassword = repeatPasswordField.getText().trim();

            // Kiểm tra tính hợp lệ của email, số điện thoại và mật khẩu
            if (email.isEmpty() || phone.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {
                errorLabel.setText("Please fill in all fields.");
            } else if (!Validator.isValidEmail(email)) {
                errorLabel.setText("Invalid email format.");
            } else if (!Validator.isValidPhoneNumber(phone)) {
                errorLabel.setText("Invalid phone number format.");
            } else if (!password.equals(repeatPassword)) {
                errorLabel.setText("Passwords do not match.");
            } else {
                // Xử lý đăng ký thành công
                errorLabel.setText("Registration successful.");  // Thay bằng logic đăng ký
            }
        });



        // Sắp xếp các thành phần trong giao diện
        VBox vbox = new VBox(10, logo, registerLabel, usernameField, emailField, phoneField, passwordField, repeatPasswordField, registerButton,errorLabel, alreadyAccountLink);
        vbox.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        Scene scene = new Scene(vbox, 300, 500);

        primaryStage.setTitle("Register");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

