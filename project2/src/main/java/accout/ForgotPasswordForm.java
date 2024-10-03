package accout;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ForgotPasswordForm{

    public void start(Stage primaryStage) {

        Image logoImage = new Image("C:\\Users\\admin\\Downloads\\demo-main\\demo2\\src\\main\\java\\Image\\logo.jpg");
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitWidth(150);  // Đặt kích thước chiều rộng của ảnh
        logoImageView.setFitHeight(100); // Đặt kích thước chiều cao của ảnh

        Label logo = new Label();
        logo.setGraphic(logoImageView);
        // Tiêu đề của form quên mật khẩu
        Label forgotPasswordLabel = new Label("Forgot Password");
        forgotPasswordLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Trường nhập email hoặc số điện thoại
        TextField emailOrPhoneField = new TextField();
        emailOrPhoneField.setPromptText("Enter your email or phone");

        // Nút gửi yêu cầu
        Button sendButton = new Button("Send Reset Password");

        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        // Liên kết để quay về giao diện đăng nhập
        Hyperlink backToLoginLink = new Hyperlink("Back to Login");

        // Sự kiện khi bấm vào "Back to Login" quay về giao diện login
        backToLoginLink.setOnAction(e -> {
            LoginForm loginView = new LoginForm();
            loginView.start(primaryStage);  // Quay lại giao diện Login
        });

        sendButton.setOnAction(e -> {
            String input = emailOrPhoneField.getText().trim();

            if (input.isEmpty()) {
                errorLabel.setText("Please enter your email or phone number.");
            } else if (Validator.isValidEmail(input)) {
                // Xử lý khi email hợp lệ
                errorLabel.setText("A reset link has been sent to your email.");
            } else if (Validator.isValidPhoneNumber(input)) {
                // Xử lý khi số điện thoại hợp lệ
                errorLabel.setText("A reset link has been sent to your phone.");
            } else {
                // Thông báo lỗi nếu cả email và số điện thoại không hợp lệ
                errorLabel.setText("Invalid email or phone number.");
            }
        });

        // Sắp xếp các thành phần trong giao diện
        VBox vbox = new VBox(10, logo,forgotPasswordLabel, emailOrPhoneField, sendButton,errorLabel, backToLoginLink);
        vbox.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        Scene scene = new Scene(vbox, 300, 300);

        primaryStage.setTitle("Forgot Password");
        primaryStage.setScene(scene);
    }
}

