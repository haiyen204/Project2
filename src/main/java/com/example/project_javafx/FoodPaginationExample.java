package com.example.project_javafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FoodPaginationExample extends Application {

    private static final int ROWS_PER_PAGE = 7;
    private ObservableList<Food> foodList = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TableView<Food> tableView = new TableView<>();
        TableColumn<Food, String> nameColumn = new TableColumn<>("Food Name");
        TableColumn<Food, Double> priceColumn = new TableColumn<>("Price");

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableView.getColumns().addAll(nameColumn, priceColumn);

        loadFoodItems(); // Tải danh sách món ăn

        Pagination pagination = new Pagination((int) Math.ceil((double) foodList.size() / ROWS_PER_PAGE));
        pagination.setPageFactory(pageIndex -> createPage(pageIndex, tableView));

        VBox vbox = new VBox(pagination, tableView);
        Scene scene = new Scene(vbox, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Food Pagination Example");
        primaryStage.show();
    }

    private VBox createPage(int pageIndex, TableView<Food> tableView) {
        VBox vbox = new VBox();
        tableView.getItems().clear(); // Xóa các mục cũ

        int fromIndex = pageIndex * ROWS_PER_PAGE;
        int toIndex = Math.min(fromIndex + ROWS_PER_PAGE, foodList.size());
        tableView.setItems(FXCollections.observableArrayList(foodList.subList(fromIndex, toIndex)));

        vbox.getChildren().add(tableView);
        return vbox;
    }

    private void loadFoodItems() {
        for (int i = 1; i <= 20; i++) { // Tạo 20 món ăn giả
            foodList.add(new Food("Food " + i, i * 5.0));
        }
    }

    public static class Food {
        private final String name;
        private final double price;

        public Food(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
}