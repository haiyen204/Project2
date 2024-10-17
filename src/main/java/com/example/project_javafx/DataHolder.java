package com.example.project_javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;

public class DataHolder {
    private static DataHolder instance;
    private ObservableList<FoodItem> foodItems = FXCollections.observableArrayList();

    private DataHolder() {}

    public static DataHolder getInstance() {
        if (instance == null) {
            instance = new DataHolder();
        }
        return instance;
    }

    public ObservableList<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void addFoodItem(FoodItem newItem) {
        for (FoodItem item : foodItems) {
            if (item.getName().equals(newItem.getName())) {
                // Cộng dồn số lượng
                item.setQuantity(item.getQuantity() + newItem.getQuantity());
                return; // Kết thúc sau khi cộng dồn
            }
        }
        // Nếu không tìm thấy, thêm mới
        foodItems.add(newItem);
    }
}
