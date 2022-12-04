package com.example.tourist_application;

import animatefx.animation.ZoomIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LoginController {
    public  static User user;
    private Stage stage;
    private Scene scene;
    @FXML
    private PasswordField passwordPf;
    @FXML
    private TextField usernameTf;


    @FXML
    protected void userLogin(ActionEvent event) throws IOException {
        String name = usernameTf.getText();
        String password = passwordPf.getText();

        user = Login.getAuthenticatedUser(name,password);

        if(user!=null)
        {
            Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        }
        System.out.println("You are in");
    }
}
