package com.example.project_javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent; // Sửa import này
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MenuButton menuButton = new MenuButton("Menu");
        MenuItem item1 = new MenuItem("Item 1");
        MenuItem item2 = new MenuItem("Item 2");

        menuButton.getItems().addAll(item1, item2);

        // Sử dụng sự kiện MouseEvent cho menuButton
        menuButton.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> menuButton.show());
        menuButton.addEventHandler(MouseEvent.MOUSE_EXITED, e -> menuButton.hide());

        StackPane root = new StackPane(menuButton);
        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("Hover Menu Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
