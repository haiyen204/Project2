package com.example.project_javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RunLoginForm extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;

        // Load the register form FXML file
//       Parent root = FXMLLoader.load(getClass().getResource("customer-management.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));

        // Set the title and scene
        primaryStage.setTitle("Restaurant Management");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void setRoot(String fxml) {
        try {
            Parent root = FXMLLoader.load(RunLoginForm.class.getResource(fxml + ".fxml"));
            primaryStage.getScene().setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
