package com.example.project_javafx;

public class FoodItem {
    private String name;
    private int quantity;
    private double price;

    public FoodItem(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotal() {
        return quantity * price; // Tính toán tổng
    }
}
