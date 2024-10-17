package com.example.project_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class FoodController {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private MenuButton menuButton;
    private boolean hoveringMenu = false;
    private boolean hoveringItem = false;

    @FXML
    private Spinner<Integer> beefsteakSpinner;

    @FXML
    private Pagination pagination;

    @FXML
    private Label menuLabel;

    @FXML
    private ImageView menuImageView1;

    @FXML
    private ImageView menuImageView2;

    @FXML
    private ImageView menuImageView3;

    @FXML
    private ImageView menuImageView4;

    @FXML
    private ImageView menuImageView5;

    @FXML
    private ImageView menuImageView6;

    @FXML
    private ImageView menuImageView7;

    @FXML
    private ImageView menuImageView8;

    @FXML
    private ImageView menuImageView9;

    @FXML
    private Spinner<?> spinner;

    private final int PAGE_COUNT = 3;

    @FXML
    private TableView<FoodItem> tableView;
    @FXML
    private TableColumn<FoodItem, String> nameColumn;
    @FXML
    private TableColumn<FoodItem, Integer> quantityColumn;
    @FXML
    private TableColumn<FoodItem, Double> priceColumn;

    @FXML
    private void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        updateTable(); // Cập nhật bảng khi khởi tạo


        if (pagination != null) {
            pagination.setPageCount(PAGE_COUNT);
            pagination.setCurrentPageIndex(0);
            pagination.setPageFactory(this::createPage);
            updatePage(0);
        } else {
            System.out.println("Pagination is null!");
        }

        beefsteakSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));

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

    private javafx.scene.Node createPage(int pageIndex) {
        updatePage(pageIndex);
        return new javafx.scene.layout.VBox(); // Trả về một VBox rỗng
    }
    public void updateTable() {
        tableView.getItems().clear();
        for (FoodItem item : DataHolder.getInstance().getFoodItems()) {
            tableView.getItems().add(item); // Thêm các món ăn vào bảng
        }
    }


    private void updatePage(int pageIndex) {
        switch (pageIndex) {
            case 0:
                menuLabel.setText("Beefsteak: 10$");
                menuImageView1.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/bittet.png")));
                menuImageView2.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/bittet.png")));
                menuImageView3.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/bittet.png")));
                menuImageView4.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/bittet.png")));
                menuImageView5.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/bittet.png")));
                menuImageView6.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/bittet.png")));
                menuImageView7.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/bittet.png")));
                menuImageView8.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/bittet.png")));
                menuImageView9.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/bittet.png")));
                break;
            case 1:
                menuLabel.setText("Menu 2");
                menuImageView1.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/bobittet.png")));
                menuImageView2.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/bobittet.png")));
                menuImageView3.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/bobittet.png")));
                menuImageView4.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/bobittet.png")));
                menuImageView5.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/bobittet.png")));
                menuImageView6.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/bobittet.png")));
                menuImageView7.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/bobittet.png")));
                menuImageView8.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/bobittet.png")));
                menuImageView9.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/bobittet.png")));
                break;
            case 2:
                menuLabel.setText("Menu 3");
                menuImageView1.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/boluclac.png")));
                menuImageView2.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/boluclac.png")));
                menuImageView3.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/boluclac.png")));
                menuImageView4.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/boluclac.png")));
                menuImageView5.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/boluclac.png")));
                menuImageView6.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/boluclac.png")));
                menuImageView7.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/boluclac.png")));
                menuImageView8.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/boluclac.png")));
                menuImageView9.setImage(new Image(getClass().getResourceAsStream("/com/example/project_javafx/anhdoan/boluclac.png")));
                break;
        }
    }

    @FXML
    private void addBeefsteak() {
        int quantity = beefsteakSpinner.getValue();
        if (quantity > 0) {
            DataHolder.getInstance().addFoodItem(new FoodItem("Beefsteak", quantity, 10.0));
            updateTable(); // Cập nhật bảng ngay sau khi thêm món ăn
        }
        beefsteakSpinner.getValueFactory().setValue(0);
    }

    public void deleteSelectedItem() {
        FoodItem selectedItem = tableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            tableView.getItems().remove(selectedItem);
            DataHolder.getInstance().getFoodItems().remove(selectedItem); // Xóa khỏi DataHolder
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
    public void switchToLogout(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("logout.fxml"));

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
