module com.example.jobthroughcontest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jobthroughcontest to javafx.fxml;
    exports com.example.jobthroughcontest;
}