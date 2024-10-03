package accout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginForm extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Tạo các thành phần giao diện

        // Thay thế logo bằng ảnh
        Image logoImage = new Image("D:\\project2\\src\\main\\java\\Image");
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitWidth(150);  // Đặt kích thước chiều rộng của ảnh
        logoImageView.setFitHeight(100); // Đặt kích thước chiều cao của ảnh

        Label logo = new Label();
        logo.setGraphic(logoImageView);

        Label loginLabel = new Label("Login");
        loginLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField emailField = new TextField();
        emailField.setPromptText("Email or phone");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Hyperlink forgotPasswordLink = new Hyperlink("Forgot password? Terms of service");
        //Chuyển giao diện quên mật khẩu
        forgotPasswordLink.setOnAction(e -> {
            ForgotPasswordForm forgotPasswordView = new ForgotPasswordForm();
            forgotPasswordView.start(primaryStage);
        });


        Button loginButton = new Button("Login");

        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        Hyperlink noAccountLabel = new Hyperlink("Do not have an account");
        noAccountLabel.setOnAction(event -> {
            RegisterForm registerView = new RegisterForm();
            registerView.start(primaryStage);
        });


        loginButton.setOnAction(e -> {
            String input = emailField.getText().trim();
            String password = passwordField.getText().trim();

            if (input.isEmpty()) {
                errorLabel.setText("Please enter your email or phone number.");
            } else if (password.isEmpty()) {
                errorLabel.setText("Please enter your password.");
            } else if (Validator.isValidEmail(input) || Validator.isValidPhoneNumber(input)) {
                // Xử lý đăng nhập nếu email hoặc số điện thoại hợp lệ
                errorLabel.setText("Login successful.");  // Thay bằng logic đăng nhập thật sự
            } else {
                // Thông báo lỗi nếu email hoặc số điện thoại không hợp lệ
                errorLabel.setText("Invalid email or phone number.");
            }
        });

        VBox vbox = new VBox(10, logo, loginLabel, emailField, passwordField, forgotPasswordLink, loginButton, errorLabel, noAccountLabel);
        vbox.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        Scene scene = new Scene(vbox, 300, 400);

        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
