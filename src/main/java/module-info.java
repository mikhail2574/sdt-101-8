module com.example.sdt1018 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sdt1018 to javafx.fxml;
    exports com.example.sdt1018;
}