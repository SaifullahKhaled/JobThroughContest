package com.example.jcb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class backloginController {
    public Parent root;
    public Stage stage;
    public Scene scene;
    @FXML
    private Label welcomeText;
    @FXML
    private TextField address;

    @FXML
    private TextField email;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private TextField phone;

    @FXML
    public void submit(ActionEvent event) throws IOException {

        if(name.getText().isEmpty()  || phone.getText().isEmpty() || email.getText().isEmpty()||password.getText().isEmpty() || address.getText().isEmpty() ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Information is missing");
            alert.show();

        }

        else if (phone.getText().length() != 11){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Phone Number is Wrong");
            alert.show();
        }
        else if (!email.getText().contains("@gmail.com")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Email is not correct");
            alert.show();
        }

        else if (password.getText().length()<8){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Password too short");

            alert.show();
        }



        else{


            DBconnect db = new DBconnect();
            Connection connection = db.connection();
            try {
            Statement statement = connection.createStatement();
            String query1 = "SELECT * FROM user WHERE phone = '"+phone.getText()+"' || email = '"+email.getText()+"'";
            //String query2 = "INSERT INTO user_table VALUES user_phone_no = '"+p_no.getText()+"' || user_email = '"+e_mail.getText()+"'";
            ResultSet resultSet = statement.executeQuery(query1);
            if(resultSet.next()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Already Registered");
                alert.show();

            }
            else{
                statement.executeUpdate("INSERT INTO user (name,email,phone,address,password) VALUES('" + name.getText() + "', '" + email.getText() + "', '" + phone.getText() + "', '" + address.getText() + "','" + password.getText()+ "')");
                // System.out.println("Data Unique");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("You are member of Job Through contest");

                alert.show();
                root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
                scene = new Scene(root);
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        }
    }


}