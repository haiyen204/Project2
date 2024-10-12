package com.example.project_javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class MyController {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private MenuButton menuButton;
    private boolean hoveringMenu = false;
    private boolean hoveringItem = false;

    public void initialize() {
        if (menuButton != null) {
            // Hiển thị menu khi hover vào menuButton
            menuButton.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
                hoveringMenu = true;
                menuButton.show(); // Đảm bảo menu hiển thị
            });

            menuButton.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
                // Ẩn menu chỉ khi không hover vào cả menu button và bất kỳ menu item nào
                if (!hoveringItem && !hoveringMenu) {
                    menuButton.hide();
                    hoveringMenu = false;
                }
            });


            // Thêm sự kiện cho từng menu item
            for (MenuItem item : menuButton.getItems()) {
                item.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
                    hoveringItem = true; // Đặt flag khi hover vào menu item
                });

                item.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
                    hoveringItem = false; // Reset flag khi ra khỏi menu item
                });
            }

            // Thêm sự kiện click cho các menu item
            for (MenuItem item : menuButton.getItems()) {
                item.setOnAction(event -> {
                    try {
                        if (item.getText().equals("Food")) {
                            switchToFood(event);
                        } else if (item.getText().equals("Drink")) {
                            switchToDrink(event);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } else {
            System.out.println("menuButton is null. Please check the FXML file.");
        }
    }

    public void switchToStaff(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("staff.fxml"));

        // Lấy stage từ event
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Lưu kích thước hiện tại
        double currentWidth = stage.getWidth();
        double currentHeight = stage.getHeight();

        // Thiết lập scene cho stage
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); // Thêm dòng này

        stage.setScene(scene); // Đặt scene cho stage

        // Thiết lập lại kích thước cửa sổ
        stage.setWidth(currentWidth);
        stage.setHeight(currentHeight);

        stage.show(); // Hiển thị stage
    }
    public void switchToCustomer(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("customer.fxml"));

        // Lấy stage từ event
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Lưu kích thước hiện tại
        double currentWidth = stage.getWidth();
        double currentHeight = stage.getHeight();

        // Thiết lập scene cho stage
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); // Thêm dòng này

        stage.setScene(scene); // Đặt scene cho stage

        // Thiết lập lại kích thước cửa sổ
        stage.setWidth(currentWidth);
        stage.setHeight(currentHeight);

        stage.show(); // Hiển thị stage
    }
    public void switchToMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("menu.fxml"));

        // Lấy stage từ event
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Lưu kích thước hiện tại
        double currentWidth = stage.getWidth();
        double currentHeight = stage.getHeight();

        // Thiết lập scene cho stage
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); // Thêm dòng này

        stage.setScene(scene); // Đặt scene cho stage

        // Thiết lập lại kích thước cửa sổ
        stage.setWidth(currentWidth);
        stage.setHeight(currentHeight);

        stage.show(); // Hiển thị stage
    }
    public void switchToFood(ActionEvent event) throws IOException {
        // Tải tệp FXML
        root = FXMLLoader.load(getClass().getResource("food.fxml"));

        // Lấy stage từ event
        Stage stage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();

        // Lưu kích thước hiện tại
        double currentWidth = stage.getWidth();
        double currentHeight = stage.getHeight();

        // Thiết lập scene cho stage
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setScene(scene); // Đặt scene cho stage

        // Thiết lập lại kích thước cửa sổ
        stage.setWidth(currentWidth);
        stage.setHeight(currentHeight);

        stage.show(); // Hiển thị stage
    }
    public void switchToDrink(ActionEvent event) throws IOException {
        // Tải tệp FXML
        root = FXMLLoader.load(getClass().getResource("drink.fxml"));

        // Lấy stage từ event
        Stage stage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();

        // Lưu kích thước hiện tại
        double currentWidth = stage.getWidth();
        double currentHeight = stage.getHeight();

        // Thiết lập scene cho stage
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setScene(scene); // Đặt scene cho stage

        // Thiết lập lại kích thước cửa sổ
        stage.setWidth(currentWidth);
        stage.setHeight(currentHeight);

        stage.show(); // Hiển thị stage
    }
    public void switchToOrder(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("order.fxml"));

        // Lấy stage từ event
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Lưu kích thước hiện tại
        double currentWidth = stage.getWidth();
        double currentHeight = stage.getHeight();

        // Thiết lập scene cho stage
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); // Thêm dòng này

        stage.setScene(scene); // Đặt scene cho stage

        // Thiết lập lại kích thước cửa sổ
        stage.setWidth(currentWidth);
        stage.setHeight(currentHeight);

        stage.show(); // Hiển thị stage
    }
    public void switchToBill(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("bill.fxml"));

        // Lấy stage từ event
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Lưu kích thước hiện tại
        double currentWidth = stage.getWidth();
        double currentHeight = stage.getHeight();

        // Thiết lập scene cho stage
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); // Thêm dòng này

        stage.setScene(scene); // Đặt scene cho stage

        // Thiết lập lại kích thước cửa sổ
        stage.setWidth(currentWidth);
        stage.setHeight(currentHeight);

        stage.show(); // Hiển thị stage
    }
    public void switchToInventory(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("inventory.fxml"));

        // Lấy stage từ event
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Lưu kích thước hiện tại
        double currentWidth = stage.getWidth();
        double currentHeight = stage.getHeight();

        // Thiết lập scene cho stage
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); // Thêm dòng này

        stage.setScene(scene); // Đặt scene cho stage

        // Thiết lập lại kích thước cửa sổ
        stage.setWidth(currentWidth);
        stage.setHeight(currentHeight);

        stage.show(); // Hiển thị stage
    }
    public void switchToReservation(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("reservation.fxml"));

        // Lấy stage từ event
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Lưu kích thước hiện tại
        double currentWidth = stage.getWidth();
        double currentHeight = stage.getHeight();

        // Thiết lập scene cho stage
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); // Thêm dòng này

        stage.setScene(scene); // Đặt scene cho stage

        // Thiết lập lại kích thước cửa sổ
        stage.setWidth(currentWidth);
        stage.setHeight(currentHeight);

        stage.show(); // Hiển thị stage
    }
    public void switchToReview(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("review.fxml"));

        // Lấy stage từ event
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Lưu kích thước hiện tại
        double currentWidth = stage.getWidth();
        double currentHeight = stage.getHeight();

        // Thiết lập scene cho stage
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); // Thêm dòng này

        stage.setScene(scene); // Đặt scene cho stage

        // Thiết lập lại kích thước cửa sổ
        stage.setWidth(currentWidth);
        stage.setHeight(currentHeight);

        stage.show(); // Hiển thị stage
    }
}

