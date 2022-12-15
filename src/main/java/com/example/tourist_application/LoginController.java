package com.example.tourist_application;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private double xOffset = 0;
    private double yOffset = 0;
    public  static User user;
    private Stage stage;
    private Scene scene;
    @FXML
    private Pane loginTopPane;
    @FXML
    private ImageView bubble1;
    @FXML
    private ImageView lampImage;
    @FXML
    private BorderPane loginPanel;
    @FXML
    private PasswordField passwordPf;
    @FXML
    private TextField usernameTf;


    @FXML
    protected void handleCloseAction(MouseEvent event)
    {
        Platform.exit();

    }
    @FXML
    protected void handleMinimizeAction(MouseEvent event)
    {
        ((Stage) loginPanel.getScene().getWindow()).setIconified(true);
    }
    @FXML
    protected void handleClickAction(MouseEvent event)
    {
        Stage stage = (Stage) loginTopPane.getScene().getWindow();
        xOffset = stage.getX() - event.getScreenX();
        yOffset = stage.getY() - event.getScreenY();
    }

    @FXML
    protected void userLogin(ActionEvent event) throws IOException {
        String name = usernameTf.getText();
        String password = passwordPf.getText();

        user = Login.getAuthenticatedUser(name,password);

        if(user!=null) {
            Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Image Animation
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(lampImage);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByY(10);
        translate.setAutoReverse(true);
        translate.play();

        //Buble Animation
        TranslateTransition bubbleAnim = new TranslateTransition();
        bubbleAnim.setNode(bubble1);
        bubbleAnim.setDuration(Duration.millis(3000));
        bubbleAnim.setCycleCount(TranslateTransition.INDEFINITE);

        bubbleAnim.setToX(675);
        bubbleAnim.setToY(-473);

        bubbleAnim.setAutoReverse(true);
        bubbleAnim.play();
    }
}
