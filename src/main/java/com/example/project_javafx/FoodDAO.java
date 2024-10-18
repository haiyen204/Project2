package com.example.project_javafx;

import com.example.project_javafx.FoodItem;

import com.example.project_javafx.dao.JDBCConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FoodDAO {
    public List<FoodItem> getFoodItems() {
        List<FoodItem> foodItems = new ArrayList<>();

        String query = "SELECT item_name, price FROM menu_items";

        try (Connection connection = JDBCConnect.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {  // Duyệt qua kết quả
                String itemName = rs.getString("item_name");
                double price = rs.getDouble("price");
                foodItems.add(new FoodItem(itemName, 0, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foodItems;
    }
}
