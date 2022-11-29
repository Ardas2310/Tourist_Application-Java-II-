package com.example.tourist_application;

import animatefx.animation.ZoomIn;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Home extends Application {

    public static void main(String[] args) {
        Api.delShopsFromDatabase();
        new Api();
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Home.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.getIcons().add(new Image(getClass().getResourceAsStream("gui/touristAppIcon.png")));

        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }
}
