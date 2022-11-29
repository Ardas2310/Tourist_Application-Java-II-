package com.example.tourist_application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class RegisterController {
    @FXML
    private TextField EmailTF;

    @FXML
    private Button registerButton;

    @FXML
    private BorderPane registerPanel;

    @FXML
    private TextField usernameTf;

    @FXML
    protected void userRegister(ActionEvent event)
    {
        //Register.addUserToDatabase();
    }
}
