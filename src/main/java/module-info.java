module com.example.jcb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.jcb to javafx.fxml;
    exports com.example.jcb;
}