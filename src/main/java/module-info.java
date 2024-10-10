module com.example.project_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.project_javafx to javafx.fxml;
    exports com.example.project_javafx;
}