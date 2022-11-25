package com.example.tourist_application;

import animatefx.animation.*;
import categories.Bar;
import categories.Cafe;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    private double xOffset = 0;
    private Scene scene;
    private Stage stage;
    private boolean isLightMode = true;
    private double yOffset = 0;

    //<editor-fold default-state="collapsed" desc=" Initialize Objects ">
    @FXML
    private ImageView closeApplication;
    @FXML
    private Label cafeStatus1;
    @FXML
    private Label cafeName1;
    @FXML
    private Label cafeRate1;
    @FXML
    private Label cafeType1;
    @FXML
    private Label resultsCafe;
    @FXML
    private ScrollPane cafeScrollPane;
    @FXML
    private ImageView nightButton;
    @FXML
    private ScrollPane homeScrollPane;
    @FXML
    private AnchorPane aHomePane;
    @FXML
    private ImageView recImage1;
    @FXML
    private Label shadowFindLabel;
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
    private Label recName3;
    @FXML
    private Label recType3;
    @FXML
    private Label recName4;
    @FXML
    private Label recType4;
    @FXML
    private Label recType5;
    @FXML
    private Label recName2;
    @FXML
    private Label recName5;
    @FXML
    private Label recType2;
    @FXML
    private Label recRate2;
    @FXML
    private Label categoryLabel;
    @FXML
    private Label recRate1;
    @FXML
    private Label recRate3;
    @FXML
    private Label recRate4;
    @FXML
    private Label recRate5;
    @FXML
    private Label recStatus2;
    @FXML
    private Label recStatus1;
    @FXML
    private Label recStatus3;
    @FXML
    private Label recStatus4;
    @FXML
    private Label recStatus5;
    @FXML
    private Button registerButton;
    @FXML
    private Label appLabel;
    @FXML
    private Label recLabel;
    @FXML
    private Label registerLabel;
    @FXML
    private ImageView foodCategory;
    @FXML
    private Label tinyNameLabel;
    @FXML
    private ImageView coffeeCategory;
    @FXML
    private Label shadowLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Pane recommendedPane;
    @FXML
    private AnchorPane welcomePane;
    @FXML
    private AnchorPane mainCategoryPane;

    //</editor-fold>

    //<editor-fold default-state="collapsed" desc=" Events ">
    @FXML
    protected void coffeeCategoryClose(MouseEvent event){

        cafeScrollPane.setVisible(false);
        homeScrollPane.setVisible(true);

    }
    @FXML
    protected void coffeeCategoryClick(MouseEvent event){
        homeScrollPane.setVisible(false);
        cafeScrollPane.setVisible(true);

        cafeScrollPane.setOpacity(0.0);
        new FadeIn(cafeScrollPane).play();

    }
   @FXML
    public void changeMode(MouseEvent event)
    {
        isLightMode = !isLightMode;
        if(isLightMode) {
            setLightMode();
        }
        else {
            setDarkMode();
        }
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
        //Cafe Initializer
        cafeScrollPane.setVisible(false);
        resultsCafe.setText(String.valueOf(Cafe.cafeCounter) + " results" );

        //<editor-fold default-state="collapsed" desc="Cafe 1">
        cafeName1.setText(Cafe.cafeName[0]);
        cafeType1.setText(Cafe.cafeType[0]);
        cafeRate1.setText(String.valueOf(Cafe.cafeRate[0]));
        cafeStatus1.setText(String.valueOf(Cafe.cafeStatus[0]));
        //</editor-fold>


        //<editor-fold default-state="collapsed" desc=" Animations ">
        appLabel.setOpacity(0.0);
        welcomeImage.setOpacity(0.0);
        descriptionLabel.setOpacity(0.0);
        registerLabel.setOpacity(0.0);
        shadowFindLabel.setOpacity(0.0);
        shadowLabel.setOpacity(0.0);
        tinyNameLabel.setOpacity(0.0);
        categoryLabel.setOpacity(0.0);
        registerButton.setOpacity(0.0);

        new ZoomIn(appLabel).setDelay(Duration.seconds(2.5)).play();
        new ZoomIn(registerButton).setDelay(Duration.seconds(2.5)).play();
        new ZoomIn(welcomeImage).setDelay(Duration.seconds(2.5)).play();
        new ZoomIn(descriptionLabel).setDelay(Duration.seconds(2.5)).play();
        new ZoomIn(registerLabel).setDelay(Duration.seconds(2.5)).play();
        new ZoomIn(shadowFindLabel).setDelay(Duration.seconds(2.5)).play();
        new ZoomIn(shadowLabel).setDelay(Duration.seconds(2.5)).play();
        new ZoomIn(tinyNameLabel).setDelay(Duration.seconds(2.5)).play();
        new ZoomIn(categoryLabel).setDelay(Duration.seconds(2.5)).play();
        //</editor-fold

        //<editor-fold default-state="collapsed" desc="Recommended Shop 1">
        recName1.setText(Cafe.cafeName[14]);
        recType1.setText(Cafe.cafeType[14]);
        recRate1.setText(String.valueOf(Cafe.cafeRate[14]));
        recStatus1.setText(String.valueOf(Cafe.cafeStatus[14]));
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Recommended Shop 2">
        recName2.setText(Bar.barName[6]);
        recType2.setText(Bar.barType[6]);
        recRate2.setText(String.valueOf(Bar.barRate[6]));
        recStatus2.setText(String.valueOf(Bar.barStatus[6]));
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Recommended Shop 2">
        recName3.setText(Cafe.cafeName[12]);
        recType3.setText(Cafe.cafeType[12]);
        recRate3.setText(String.valueOf(Cafe.cafeRate[12]));
        recStatus3.setText(String.valueOf(Cafe.cafeStatus[12]));
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Recommended Shop 2">
        recName4.setText(Cafe.cafeName[5]);
        recType4.setText(Cafe.cafeType[5]);
        recRate4.setText(String.valueOf(Cafe.cafeRate[5]));
        recStatus4.setText(String.valueOf(Cafe.cafeStatus[5]));
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Recommended Shop 2">
        recName5.setText(Cafe.cafeName[4]);
        recType5.setText(Cafe.cafeType[4]);
        recRate5.setText(String.valueOf(Cafe.cafeRate[4]));
        recStatus5.setText(String.valueOf(Cafe.cafeStatus[4]));
        //</editor-fold>
    }

    private void setLightMode() {
        mainPane.getStylesheets().remove("nightMode.css");
        mainPane.getStylesheets().add("lightMode.css");
    }

    private void setDarkMode() {
        mainPane.getStylesheets().remove("lightMode.css");
        mainPane.getStylesheets().add("nightMode.css");
    }
}




















