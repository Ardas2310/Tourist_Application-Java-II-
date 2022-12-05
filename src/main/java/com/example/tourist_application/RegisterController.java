package com.example.tourist_application;

import animatefx.animation.ZoomIn;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    private double xOffset = 0;
    private double yOffset = 0;
    private Stage stage;
    private Scene scene;
    @FXML
    private TextField EmailTF;
    @FXML
    private Button registerButton;
    @FXML
    private BorderPane registerPanel;
    @FXML
    private TextField usernameTf;
    @FXML
    private TextField mobileTf;
    @FXML
    private TextField adressTf;
    @FXML
    private PasswordField passwordPf;
    @FXML
    private Button loginButton;
    @FXML
    private Pane registerTopPane;
    @FXML
    private ImageView registerImage;

    @FXML
    protected void userRegister(ActionEvent event)
    {
        String name = usernameTf.getText();
        String email = EmailTF.getText();
        String phone = mobileTf.getText();
        String address = adressTf.getText();
        String password = passwordPf.getText();

        Register.addUserToDatabase(2,name,email,phone,address,password,"");
    }

    @FXML
    protected void loadLoginForm(ActionEvent event) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);

        //stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        new ZoomIn(root).play();
    }
    @FXML
    protected void handleCloseAction(MouseEvent event)
    {
        Platform.exit();

    }
    @FXML
    protected void handleMinimizeAction(MouseEvent event)
    {
        ((Stage) registerPanel.getScene().getWindow()).setIconified(true);
    }
    @FXML
    protected void handleClickAction(MouseEvent event)
    {
        Stage stage = (Stage) registerTopPane.getScene().getWindow();
        xOffset = stage.getX() - event.getScreenX();
        yOffset = stage.getY() - event.getScreenY();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Image Animation
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(registerImage);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByY(20);
        translate.setAutoReverse(true);
        translate.play();
    }
}
