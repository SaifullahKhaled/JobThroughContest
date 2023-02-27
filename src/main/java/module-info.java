module com.example.jcb {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jcb to javafx.fxml;
    exports com.example.jcb;
}