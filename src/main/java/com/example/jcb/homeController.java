package com.example.jcb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class homeController {
    public Parent root;
    public Stage stage;
    public Scene scene;
    @FXML
    private Label welcomeText;

    @FXML
    public void gotodashboard(ActionEvent event) throws IOException {
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
        scene = new Scene(root);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void gotodapplyforjob(ActionEvent event) throws IOException {
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("applyforjob.fxml")));
        scene = new Scene(root);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void gotocreatjob(ActionEvent event) throws IOException {
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("creatjob.fxml")));
        scene = new Scene(root);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void gotochat(ActionEvent event) throws IOException {
        root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("chat.fxml")));
        scene = new Scene(root);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void logout(ActionEvent event){
        System.exit(0);
    }

}