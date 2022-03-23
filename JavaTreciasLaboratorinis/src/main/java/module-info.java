module com.example.javatreciaslaboratorinis {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javatreciaslaboratorinis to javafx.fxml;
    exports com.example.javatreciaslaboratorinis;
}