module com.example.javafxprojektas1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxprojektas1 to javafx.fxml;
    exports com.example.javafxprojektas1;
}