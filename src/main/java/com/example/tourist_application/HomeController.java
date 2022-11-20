package com.example.tourist_application;

import animatefx.animation.*;
import categories.Recommended;
import categories.RecommendedController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    private double xOffset = 0;
    private double yOffset = 0;
    private List<Recommended> recommendedList;

    //<editor-fold defaultstate="collapsed" desc=" Initialize Objects ">
    @FXML
    private ImageView closeApplication;
    @FXML
    private TextField searchTextBox;
    @FXML
    private GridPane recGridPane;
    @FXML
    private ImageView welcomeImage;
    @FXML
    private BorderPane mainPane;
    @FXML
    private Pane searchPane;
    @FXML
    private AnchorPane recPanel1;
    @FXML
    private ImageView minimizeApp;
    @FXML
    private Pane topPane;
    @FXML
    private Label recName1;
    @FXML
    private Label recType1;
    @FXML
    private Label categoryLabel;
    @FXML
    private Label recRate1;
    @FXML
    private Label recLabel;
    @FXML
    private ImageView foodCategory;
    @FXML
    private ImageView coffeeCategory;
    @FXML
    private Pane recommendedPane;

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Events ">
    @FXML
    protected void coffeeCategoryClick(MouseEvent event)
    {
        recPanel1.setVisible(false);
    }
    @FXML
    protected void handleCloseAction(MouseEvent event)
    {
        Platform.exit();

    }
    @FXML
    protected void handleMinimizeAction(MouseEvent event)
    {
        ((Stage) mainPane.getScene().getWindow()).setIconified(true);
    }
    @FXML
    protected void handleClickAction(MouseEvent event)
    {
        Stage stage = (Stage) topPane.getScene().getWindow();
        xOffset = stage.getX() - event.getScreenX();
        yOffset = stage.getY() - event.getScreenY();
    }
    @FXML
    protected void onMouseEnterCategory(MouseEvent event)
    {
        //TODO: Import Animation
    }
    @FXML
    protected void onMouseExitCategory(MouseEvent event)
    {
        //TODO: Import Animation
    }
    @FXML
    protected void handleMovementAction(MouseEvent event)
    {
        Stage stage = (Stage) topPane.getScene().getWindow();
        stage.setX(event.getScreenX() + xOffset);
        stage.setY(event.getScreenY() + yOffset);
    }
    //</editor-fold>

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        //<editor-fold defaultstate="collapsed" desc=" Animations ">
        new ZoomIn(categoryLabel).setDelay(Duration.seconds(1.5)).play();
        new ZoomIn(coffeeCategory).setDelay(Duration.seconds(1.5)).play();
        new ZoomIn(recLabel).setDelay(Duration.seconds(1.5)).play();
        new ZoomIn(recPanel1).setDelay(Duration.seconds(1.5)).play();
        new ZoomIn(foodCategory).setDelay(Duration.seconds(1.5)).play();
        new ZoomIn(welcomeImage).setDelay(Duration.seconds(1.5)).play();
        new ZoomIn(categoryLabel).setDelay(Duration.seconds(1.5)).play();
        //</editor-fold

        recommendedList = new ArrayList<>(data());
        int columns = 0;
        int rows =1 ;
        try
        {
            for(int i=0; i<recommendedList.size();i++)
            {
                FXMLLoader root = new FXMLLoader();
                root.setLocation(getClass().getResource("recommended.fxml"));

                AnchorPane recPane = root.load();
                RecommendedController recommendedController = root.getController();
                recommendedController.setData(recommendedList.get(i));

                recGridPane.add(recPane,columns,rows);
                GridPane.setMargin(recPane,new Insets(10));
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private List<Recommended> data()
    {
        List <Recommended> recls  = new ArrayList<>();

        Recommended recommended = new Recommended();
        recommended.setShopName1("recommended.shopName1");
        recommended.setShopRate1("recommended.shopRate1");
        recommended.setShopType1("recommended.shopType1");
        return  recls;


    }
}