module com.example.codingtest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.codingtest to javafx.fxml;
    exports com.example.codingtest;
}