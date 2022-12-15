package com.example.tourist_application;

import animatefx.animation.*;
import categories.*;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    String[] options = {"Kouzina", "goal cafe ", "melios oil ", "xryso ", "Today's Delicious stores ", "to spitiko ", "the coffee store 2 " , "cityzen " , "the coffee store"};
    private double xOffset = 0;
    private boolean isFavourite = false;
    public  static User user;
    private boolean isRating = false;
    private boolean isLightMode = true;
    private double yOffset = 0;
    private Scene scene;
    private  Parent root;
    private Stage stage;
    public String[] cat = new String[]{"Cafe", "Bars", "Restaurants"};

    //<editor-fold default-state="collapsed" desc=" Initialize Objects ">
    @FXML
    private Pane cafePane1;
    @FXML
    private PasswordField passwordPf;
    @FXML
    private Pane accessPane;
    @FXML
    private Label userLabel;
    @FXML
    private TextField usernameTf;
    @FXML
    private Pane loginAnchorPane;
    @FXML
    private Button loginButton;
    @FXML
    private ImageView bubble1;
    @FXML
    private Pane ratePane;
    @FXML
    private ImageView rateButton1;
    @FXML
    private ImageView rateButton2;
    @FXML
    private ImageView rateButton3;
    @FXML
    private ImageView rateButton4;
    @FXML
    private ImageView rateButton5;
    @FXML
    private Pane searchResultsPanel;
    @FXML
    private ImageView recOpenStatus3;
    @FXML
    private ImageView recCloseStatus3;
    @FXML
    private ImageView recOpenStatus4;
    @FXML
    private ImageView recCloseStatus4;
    @FXML
    private ImageView recOpenStatus5;
    @FXML
    private ImageView recCloseStatus5;
    @FXML
    private Pane findItPane;
    @FXML
    private VBox searchVbox;
    @FXML
    private ImageView modeButton;
    @FXML
    private Label categoriesLabel;
    @FXML
    private Pane welcomeMainPane;
    @FXML
    private Label welcomeToLabel;
    @FXML
    private ImageView favouriteCafe1;
    @FXML
    private Label bulletProfileLabel;
    @FXML
    private ImageView cafeCloseStatus1;
    @FXML
    private Label cafeRate3;
    @FXML
    private ImageView closeProfileImage;
    @FXML
    private ImageView cafeOpenStatus1;
    @FXML
    private ImageView openProfileImage;
    @FXML
    private Label nameProfileLabel;
    @FXML
    private Label typeProfileLabel;
    @FXML
    private ImageView profileImage;
    @FXML
    private ScrollPane profilePane;
    @FXML
    private WebView map;
    @FXML
    private Label cafeName1;
    @FXML
    private Label cafeRate1;
    @FXML
    private Label cafeType1;
    @FXML
    private Label resultsCafe;
    @FXML
    private AnchorPane cafeScrollPane;
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
    private Button favButton1;
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
    private ImageView  cafeOpenStatus2;
    @FXML
    private ImageView closeOpenStatus2;
    @FXML
    private Label cafeName2 ;
    @FXML
    private Label cafeType2;
    @FXML
    private Pane cafePane2;
    @FXML
    private Label cafeName3 ;
    @FXML
    private Label cafeType3;
    @FXML
    private Pane cafePane3;
    @FXML
    private ImageView coffeeCategory;
    @FXML
    private  ImageView cafeCloseStatus2;
    @FXML
    private  ImageView cafeCloseStatus3;
    @FXML
    private  ImageView cafeOpenStatus3;
    @FXML
    private Label cafeRate2;
    @FXML
    private Label shadowLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private ImageView titleBarImage;
    @FXML
    private ImageView recOpenStatus1;
    @FXML
    private ImageView recCloseStatus1;
    @FXML
    private ImageView recOpenStatus2;
    @FXML
    private ImageView recCloseStatus2;
    @FXML
    private Pane recommendedPane;
    @FXML
    private ImageView lampImage;
    @FXML
    private AnchorPane welcomePane;
    @FXML
    private AnchorPane mainCategoryPane;
    @FXML
    private ImageView parksCategory;
    @FXML
    private ImageView nightCategory;
    @FXML
    private ImageView circleImage1;
    @FXML
    private ImageView modelImage;
    @FXML
    private ImageView musuemsCategory;
    @FXML
    private ImageView churchCategory;
    @FXML
    private AnchorPane recPanel2;
    @FXML
    private AnchorPane recPanel3;
    @FXML
    private AnchorPane recPanel4;
    @FXML
    private AnchorPane recPanel5;

    //</editor-fold>

    //<editor-fold default-state="collapsed" desc=" Events ">

    //<editor-fold default-state="collapsed" desc=" Cafe Profiles ">
    @FXML
    protected  void generateBlueGiakasProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Cafe.cafeName[0]);
        typeProfileLabel.setText(Cafe.cafeType[0]);
        if(String.valueOf(Cafe.cafeStatus[0]).equals("true"))
        {
            openProfileImage.setOpacity(0.0);
            new FadeIn(openProfileImage).setDelay(Duration.seconds(0.5)).play();
            openProfileImage.setVisible(true);
            closeProfileImage.setVisible(false);
        }
        else
        {
            closeProfileImage.setOpacity(0.0);
            new FadeIn(closeProfileImage).setDelay(Duration.seconds(0.5)).play();
            closeProfileImage.setVisible(true);
            openProfileImage.setVisible(false);
        }

        final WebEngine web = map.getEngine();
        String urlweb = "https://snazzymaps.com/embed/442864";
        web.load(urlweb);



        //<editor-fold default-state="collapsed" desc=" Profile Form Animations">
        map.setOpacity(0.0);
        new FadeIn(map).setDelay(Duration.seconds(0.5)).play();
        profileImage.setOpacity(0.0);
        new FadeIn(profileImage).setDelay(Duration.seconds(0.5)).play();
        nameProfileLabel.setOpacity(0.0);
        new FadeIn(nameProfileLabel).setDelay(Duration.seconds(0.5)).play();
        typeProfileLabel.setOpacity(0.0);
        new FadeIn(typeProfileLabel).setDelay(Duration.seconds(0.5)).play();
        bulletProfileLabel.setOpacity(0.0);
        new FadeIn(bulletProfileLabel).setDelay(Duration.seconds(0.5)).play();
        //</editor-fold

    }
    @FXML
    protected  void generateCaffetterieProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/caffettieri/profile.png")));
        nameProfileLabel.setText(Cafe.cafeName[1]);
        typeProfileLabel.setText(Cafe.cafeType[1]);
        if(String.valueOf(Cafe.cafeStatus[1]).equals("true"))
        {
            openProfileImage.setOpacity(0.0);
            new FadeIn(openProfileImage).setDelay(Duration.seconds(0.5)).play();
            openProfileImage.setVisible(true);
            closeProfileImage.setVisible(false);
        }
        else
        {
            closeProfileImage.setOpacity(0.0);
            new FadeIn(closeProfileImage).setDelay(Duration.seconds(0.5)).play();
            closeProfileImage.setVisible(true);
            openProfileImage.setVisible(false);
        }

        final WebEngine web = map.getEngine();
        String urlweb = "https://snazzymaps.com/embed/442859";
        web.load(urlweb);


        //<editor-fold default-state="collapsed" desc=" Profile Form Animations">
        map.setOpacity(0.0);
        new FadeIn(map).setDelay(Duration.seconds(0.5)).play();
        profileImage.setOpacity(0.0);
        new FadeIn(profileImage).setDelay(Duration.seconds(0.5)).play();
        nameProfileLabel.setOpacity(0.0);
        new FadeIn(nameProfileLabel).setDelay(Duration.seconds(0.5)).play();
        typeProfileLabel.setOpacity(0.0);
        new FadeIn(typeProfileLabel).setDelay(Duration.seconds(0.5)).play();
        bulletProfileLabel.setOpacity(0.0);
        new FadeIn(bulletProfileLabel).setDelay(Duration.seconds(0.5)).play();
        //</editor-fold
    }
    @FXML
    protected  void generateVoiceEspressoProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/voice_espresso/profile.png")));
        nameProfileLabel.setText(Cafe.cafeName[2]);
        typeProfileLabel.setText(Cafe.cafeType[2]);
        if(String.valueOf(Cafe.cafeStatus[2]).equals("true"))
        {
            openProfileImage.setOpacity(0.0);
            new FadeIn(openProfileImage).setDelay(Duration.seconds(0.5)).play();
            openProfileImage.setVisible(true);
            closeProfileImage.setVisible(false);
        }
        else
        {
            closeProfileImage.setOpacity(0.0);
            new FadeIn(closeProfileImage).setDelay(Duration.seconds(0.5)).play();
            closeProfileImage.setVisible(true);
            openProfileImage.setVisible(false);
        }

        final WebEngine web = map.getEngine();
        String urlweb = "https://snazzymaps.com/embed/442866";
        web.load(urlweb);


        //<editor-fold default-state="collapsed" desc=" Profile Form Animations">
        map.setOpacity(0.0);
        new FadeIn(map).setDelay(Duration.seconds(0.5)).play();
        profileImage.setOpacity(0.0);
        new FadeIn(profileImage).setDelay(Duration.seconds(0.5)).play();
        nameProfileLabel.setOpacity(0.0);
        new FadeIn(nameProfileLabel).setDelay(Duration.seconds(0.5)).play();
        typeProfileLabel.setOpacity(0.0);
        new FadeIn(typeProfileLabel).setDelay(Duration.seconds(0.5)).play();
        bulletProfileLabel.setOpacity(0.0);
        new FadeIn(bulletProfileLabel).setDelay(Duration.seconds(0.5)).play();
        //</editor-fold
    }

    //</editor-fold>

    @FXML
    protected void  enteredCategoryAnimation(MouseEvent event)
    {
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(foodCategory);
        scaleTransition.setDuration(Duration.millis(300));
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.play();
    }

    @FXML
    protected void  exitedCategoryAnimation(MouseEvent event){
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(foodCategory);
        scaleTransition.setDuration(Duration.millis(300));
        scaleTransition.setFromX(1.1);
        scaleTransition.setFromY(1.1);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.play();
    }


    @FXML
    protected void showSearchPanel(MouseEvent event)
    {
        //populateDropDownMenu(searchTextBox.getText(), options);
        searchResultsPanel.setVisible(true);
        searchResultsPanel.setOpacity(0.0);
        new FadeIn(searchResultsPanel).play();
    }

    @FXML
    protected void hideSearchPanel(MouseEvent event)
    {
        //populateDropDownMenu(searchTextBox.getText(), options);
        searchResultsPanel.setVisible(false);
    }

    //<editor-fold default-state="collapsed" desc=" Rating Fill ">
    @FXML
    protected void fillRateButton1(MouseEvent event)
    {
        rateButton1.setImage(new Image(getClass().getResourceAsStream("gui/rating-fill.png")));
    }
    @FXML
    protected void emptyRateButton1(MouseEvent event){
        rateButton1.setImage(new Image(getClass().getResourceAsStream("gui/rating.png")));
    }
    @FXML
    protected void fillRateButton2(MouseEvent event)
    {
        rateButton1.setImage(new Image(getClass().getResourceAsStream("gui/rating-fill.png")));
        rateButton2.setImage(new Image(getClass().getResourceAsStream("gui/rating-fill.png")));
    }
    @FXML
    protected void emptyRateButton2(MouseEvent event){
        rateButton1.setImage(new Image(getClass().getResourceAsStream("gui/rating.png")));
        rateButton2.setImage(new Image(getClass().getResourceAsStream("gui/rating.png")));
    }
    @FXML
    protected void fillRateButton3(MouseEvent event)
    {
        rateButton1.setImage(new Image(getClass().getResourceAsStream("gui/rating-fill.png")));
        rateButton2.setImage(new Image(getClass().getResourceAsStream("gui/rating-fill.png")));
        rateButton3.setImage(new Image(getClass().getResourceAsStream("gui/rating-fill.png")));

    }
    @FXML
    protected void emptyRateButton3(MouseEvent event){
        rateButton1.setImage(new Image(getClass().getResourceAsStream("gui/rating.png")));
        rateButton2.setImage(new Image(getClass().getResourceAsStream("gui/rating.png")));
        rateButton3.setImage(new Image(getClass().getResourceAsStream("gui/rating.png")));
    }
    @FXML
    protected void fillRateButton4(MouseEvent event)
    {
        rateButton1.setImage(new Image(getClass().getResourceAsStream("gui/rating-fill.png")));
        rateButton2.setImage(new Image(getClass().getResourceAsStream("gui/rating-fill.png")));
        rateButton3.setImage(new Image(getClass().getResourceAsStream("gui/rating-fill.png")));
        rateButton4.setImage(new Image(getClass().getResourceAsStream("gui/rating-fill.png")));
    }
    @FXML
    protected void emptyRateButton4(MouseEvent event){
        rateButton1.setImage(new Image(getClass().getResourceAsStream("gui/rating.png")));
        rateButton2.setImage(new Image(getClass().getResourceAsStream("gui/rating.png")));
        rateButton3.setImage(new Image(getClass().getResourceAsStream("gui/rating.png")));
        rateButton4.setImage(new Image(getClass().getResourceAsStream("gui/rating.png")));
    }
    @FXML
    protected void fillRateButton5(MouseEvent event)
    {
        rateButton1.setImage(new Image(getClass().getResourceAsStream("gui/rating-fill.png")));
        rateButton2.setImage(new Image(getClass().getResourceAsStream("gui/rating-fill.png")));
        rateButton3.setImage(new Image(getClass().getResourceAsStream("gui/rating-fill.png")));
        rateButton4.setImage(new Image(getClass().getResourceAsStream("gui/rating-fill.png")));
        rateButton5.setImage(new Image(getClass().getResourceAsStream("gui/rating-fill.png")));
    }
    @FXML
    protected void emptyRateButton5(MouseEvent event){
        rateButton1.setImage(new Image(getClass().getResourceAsStream("gui/rating.png")));
        rateButton2.setImage(new Image(getClass().getResourceAsStream("gui/rating.png")));
        rateButton3.setImage(new Image(getClass().getResourceAsStream("gui/rating.png")));
        rateButton4.setImage(new Image(getClass().getResourceAsStream("gui/rating.png")));
        rateButton5.setImage(new Image(getClass().getResourceAsStream("gui/rating.png")));
    }

    //</editor-fold>

    //<editor-fold default-state="collapsed" desc=" Other ">
    @FXML
    protected void userLogin(ActionEvent event){
        String name = usernameTf.getText();
        String password = passwordPf.getText();

        user = Login.getAuthenticatedUser(name,password);

        if(user.name !=null){
            //<editor-fold default-state="collapsed" desc=" loadApp ">
            loginAnchorPane.setVisible(false);
            welcomeMainPane.setVisible(false);
            new BounceOut(modelImage).setDelay(Duration.seconds(0.5)).play();
            new BounceOut(lampImage).setDelay(Duration.seconds(0.7)).play();
            new BounceOut(circleImage1).setDelay(Duration.seconds(0.7)).play();
            new ZoomOut(welcomeMainPane).setDelay(Duration.seconds(1)).play();
            homeScrollPane.setVisible(true);
            appLabel.setVisible(true);
            searchPane.setVisible(true);

            categoriesLabel.setOpacity(0.0);
            foodCategory.setOpacity(0.0);
            parksCategory.setOpacity(0.0);
            coffeeCategory.setOpacity(0.0);
            nightCategory.setOpacity(0.0);
            musuemsCategory.setOpacity(0.0);
            churchCategory.setOpacity(0.0);
            appLabel.setOpacity(0.0);
            searchPane.setOpacity(0.0);

            recLabel.setOpacity(0.0);
            recPanel1.setOpacity(0.0);
            recPanel2.setOpacity(0.0);
            recPanel3.setOpacity(0.0);
            recPanel4.setOpacity(0.0);
            recPanel5.setOpacity(0.0);

            recOpenStatus1.setOpacity(0.0);
            recCloseStatus1.setOpacity(0.0);
            recOpenStatus2.setOpacity(0.0);
            recCloseStatus2.setOpacity(0.0);
            recOpenStatus3.setOpacity(0.0);
            recCloseStatus3.setOpacity(0.0);
            recOpenStatus4.setOpacity(0.0);
            recCloseStatus4.setOpacity(0.0);
            recOpenStatus5.setOpacity(0.0);
            recCloseStatus5.setOpacity(0.0);

            new ZoomIn(categoriesLabel).play();
            new ZoomIn(recLabel).play();
            new ZoomIn(appLabel).play();
            new ZoomIn(searchPane).play();

            new ZoomIn(foodCategory).setDelay(Duration.seconds(1)).play();
            new ZoomIn(coffeeCategory).setDelay(Duration.seconds(1.5)).play();
            new ZoomIn(parksCategory).setDelay(Duration.seconds(2)).play();
            new ZoomIn(nightCategory).setDelay(Duration.seconds(2.5)).play();
            new ZoomIn(musuemsCategory).setDelay(Duration.seconds(3)).play();
            new ZoomIn(churchCategory).setDelay(Duration.seconds(3.5)).play();

            new ZoomIn(recPanel1).setDelay(Duration.seconds(1)).play();
            new ZoomIn(recPanel2).setDelay(Duration.seconds(1.5)).play();
            new ZoomIn(recPanel3).setDelay(Duration.seconds(2)).play();
            new ZoomIn(recPanel4).setDelay(Duration.seconds(2.5)).play();
            new ZoomIn(recPanel5).setDelay(Duration.seconds(3)).play();

            GenerateRecommended();
            //</editor-fold
            userLabel.setText(User.name);
        }
    }
    @FXML
    protected void guestEnterEvent(ActionEvent event)
    {
        //welcomeMainPane.setVisible(false);
        new BounceOut(modelImage).setDelay(Duration.seconds(0.5)).play();
        new BounceOut(lampImage).setDelay(Duration.seconds(0.7)).play();
        new BounceOut(circleImage1).setDelay(Duration.seconds(0.7)).play();
        new ZoomOut(welcomeMainPane).setDelay(Duration.seconds(1)).play();
        homeScrollPane.setVisible(true);
        appLabel.setVisible(true);
        searchPane.setVisible(true);

        categoriesLabel.setOpacity(0.0);
        foodCategory.setOpacity(0.0);
        parksCategory.setOpacity(0.0);
        coffeeCategory.setOpacity(0.0);
        nightCategory.setOpacity(0.0);
        musuemsCategory.setOpacity(0.0);
        churchCategory.setOpacity(0.0);
        appLabel.setOpacity(0.0);
        searchPane.setOpacity(0.0);

        recLabel.setOpacity(0.0);
        recPanel1.setOpacity(0.0);
        recPanel2.setOpacity(0.0);
        recPanel3.setOpacity(0.0);
        recPanel4.setOpacity(0.0);
        recPanel5.setOpacity(0.0);

        recOpenStatus1.setOpacity(0.0);
        recCloseStatus1.setOpacity(0.0);
        recOpenStatus2.setOpacity(0.0);
        recCloseStatus2.setOpacity(0.0);
        recOpenStatus3.setOpacity(0.0);
        recCloseStatus3.setOpacity(0.0);
        recOpenStatus4.setOpacity(0.0);
        recCloseStatus4.setOpacity(0.0);
        recOpenStatus5.setOpacity(0.0);
        recCloseStatus5.setOpacity(0.0);

        new ZoomIn(categoriesLabel).play();
        new ZoomIn(recLabel).play();
        new ZoomIn(appLabel).play();
        new ZoomIn(searchPane).play();

        new ZoomIn(foodCategory).setDelay(Duration.seconds(1)).play();
        new ZoomIn(coffeeCategory).setDelay(Duration.seconds(1.5)).play();
        new ZoomIn(parksCategory).setDelay(Duration.seconds(2)).play();
        new ZoomIn(nightCategory).setDelay(Duration.seconds(2.5)).play();
        new ZoomIn(musuemsCategory).setDelay(Duration.seconds(3)).play();
        new ZoomIn(churchCategory).setDelay(Duration.seconds(3.5)).play();

        new ZoomIn(recPanel1).setDelay(Duration.seconds(1)).play();
        new ZoomIn(recPanel2).setDelay(Duration.seconds(1.5)).play();
        new ZoomIn(recPanel3).setDelay(Duration.seconds(2)).play();
        new ZoomIn(recPanel4).setDelay(Duration.seconds(2.5)).play();
        new ZoomIn(recPanel5).setDelay(Duration.seconds(3)).play();

        GenerateRecommended();
    }
    @FXML
    protected void closeProfilePane(MouseEvent event)
    {
        profilePane.setVisible(false);
    }
    @FXML
    protected void addToFavourites(MouseEvent event)
    {
        if(user.name != null){
            isFavourite = !isFavourite;
            if(isFavourite) {
                setFavourite();
            }
            else {
                setFavouriteFill();
            }
        }
        else{
            System.out.println("You dont");
            accessPane.setVisible(true);
            new Shake(accessPane).play();
        }


    }
    @FXML
    protected void loadRegisterForm(ActionEvent event) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);

        //stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        new ZoomIn(root).play();
    }

    @FXML
    protected void loadLoginForm(ActionEvent event) throws Exception{
        loginAnchorPane.setVisible(true);
    }
    @FXML
    protected void coffeeCategoryClose(MouseEvent event){

        cafeScrollPane.setVisible(false);
        homeScrollPane.setVisible(true);
    }
    @FXML
    protected void coffeeCategoryClick(MouseEvent event){

        //ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(300), coffeeCategory);
        //scaleTransition.setNode(coffeeCategory);

        //scaleTransition.setFromX(1);
        //scaleTransition.setFromY(1);
        //scaleTransition.setToX(0.95);
        //scaleTransition.setToY(0.95);
        //scaleTransition.setAutoReverse(true);

        //scaleTransition.play();


        homeScrollPane.setVisible(false);
        cafeScrollPane.setVisible(true);

        cafeScrollPane.setOpacity(0.0);
        new FadeIn(cafeScrollPane).play();

        GenerateCafe();

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

    @FXML
    public void changeMode(MouseEvent event) {
        isLightMode = !isLightMode;
        if(isLightMode) {
            setLightMode();
        }
        else {
            setDarkMode();
        }
    }
    //</editor-fold>
    //</editor-fold>


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        //Welcome Panel
        appLabel.setVisible(false);
        searchPane.setVisible(false);
        homeScrollPane.setVisible(false);
        profilePane.setVisible(false);
        loginAnchorPane.setVisible(false);
        accessPane.setVisible(false);

        //Status
        openProfileImage.setVisible(false);
        closeProfileImage.setVisible(false);

        //Search
        searchResultsPanel.setVisible(false);

        //CafeStatus
        cafeOpenStatus1.setVisible(false);
        cafeCloseStatus1.setVisible(false);
        cafeOpenStatus2.setVisible(false);
        cafeCloseStatus2.setVisible(false);
        cafeOpenStatus3.setVisible(false);
        cafeCloseStatus3.setVisible(false);

        //Cafe Initializer
        cafeScrollPane.setVisible(false);
        resultsCafe.setText(String.valueOf(Cafe.cafeCounter) + " results" );

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
        welcomeToLabel.setOpacity(0.0);
        modelImage.setOpacity(0.0);
        lampImage.setOpacity(0.0);
        circleImage1.setOpacity(0.0);
        titleBarImage.setOpacity(0.0);



        new ZoomIn(appLabel).setDelay(Duration.seconds(3)).play();
        new ZoomIn(registerButton).setDelay(Duration.seconds(3)).play();
        new ZoomIn(welcomeImage).setDelay(Duration.seconds(3)).play();
        new ZoomIn(descriptionLabel).setDelay(Duration.seconds(3)).play();
        new ZoomIn(registerLabel).setDelay(Duration.seconds(3)).play();
        new ZoomIn(shadowFindLabel).setDelay(Duration.seconds(3)).play();
        new ZoomIn(shadowLabel).setDelay(Duration.seconds(3)).play();
        new ZoomIn(tinyNameLabel).setDelay(Duration.seconds(3)).play();
        new ZoomIn(categoryLabel).setDelay(Duration.seconds(3)).play();
        new ZoomIn(tinyNameLabel).setDelay(Duration.seconds(3)).play();
        new ZoomIn(welcomeToLabel).setDelay(Duration.seconds(3)).play();
        new ZoomIn(modelImage).setDelay(Duration.seconds(3.5)).play();
        new ZoomIn(lampImage).setDelay(Duration.seconds(3.5)).play();
        new ZoomIn(circleImage1).setDelay(Duration.seconds(3.5)).play();
        new ZoomIn(titleBarImage).setDelay(Duration.seconds(3.5)).play();




        ////Image Animation
        TranslateTransition modelTranslate = new TranslateTransition();
        modelTranslate.setNode(modelImage);
        modelTranslate.setDuration(Duration.millis(1000));
        modelTranslate.setCycleCount(TranslateTransition.INDEFINITE);
        modelTranslate.setByY(20);
        modelTranslate.setAutoReverse(true);
        modelTranslate.play();

        TranslateTransition lampTranslate = new TranslateTransition();
        lampTranslate.setNode(lampImage);
        lampTranslate.setDuration(Duration.millis(1000));
        lampTranslate.setCycleCount(TranslateTransition.INDEFINITE);
        lampTranslate.setByY(20);
        lampTranslate.setAutoReverse(true);
        lampTranslate.play();

        TranslateTransition circleTranslate = new TranslateTransition();
        circleTranslate.setNode(circleImage1);
        circleTranslate.setDuration(Duration.millis(1000));
        circleTranslate.setCycleCount(TranslateTransition.INDEFINITE);
        circleTranslate.setByY(20);
        circleTranslate.setAutoReverse(true);
        circleTranslate.play();
        //</editor-fold

        //Login Pane
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

        searchTextBox.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.equals("")){
                searchVbox.getChildren().clear();
            }
            searchVbox.getChildren().clear();
            populateDropDownMenu(searchTextBox.getText(), options);
        });
    }

    public void GenerateCafe()
    {
        //<editor-fold default-state="collapsed" desc="Cafe 1">
        cafePane1.setOpacity(0.0);
        new ZoomIn(cafePane1).setDelay(Duration.seconds(0.5)).play();
        cafeName1.setText(Cafe.cafeName[0]);
        cafeType1.setText(Cafe.cafeType[0]);
        cafeRate1.setText(String.valueOf(Cafe.cafeRate[0]));
        if(String.valueOf(Cafe.cafeStatus[0]).equals("true"))
        {
            cafeOpenStatus1.setVisible(true);
        }
        else
        {
            cafeCloseStatus1.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Cafe 2">
        cafePane2.setOpacity(0.0);
        new ZoomIn(cafePane2).setDelay(Duration.seconds(0.5)).play();
        cafeName2.setText(Cafe.cafeName[1]);
        cafeType2.setText(Cafe.cafeType[1]);
        cafeRate2.setText(String.valueOf(Cafe.cafeRate[1]));
        if(String.valueOf(Cafe.cafeStatus[1]).equals("true"))
        {
            cafeOpenStatus2.setVisible(true);
        }
        else
        {
            cafeCloseStatus2.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Cafe 3">
        cafePane3.setOpacity(0.0);
        new ZoomIn(cafePane3).setDelay(Duration.seconds(0.5)).play();
        cafeName3.setText(Cafe.cafeName[2]);
        cafeType3.setText(Cafe.cafeType[2]);
        cafeRate3.setText(String.valueOf(Cafe.cafeRate[2]));
        if(String.valueOf(Cafe.cafeStatus[2]).equals("true"))
        {
            cafeOpenStatus3.setVisible(true);
        }
        else
        {
            cafeCloseStatus3.setVisible(true);
        }
        //</editor-fold>


    }

    public void GenerateRecommended()
    {
        //<editor-fold default-state="collapsed" desc="Recommended Shop 1">
        recName1.setText(Church.churchName[2]);
        recType1.setText(Church.churchType[2]);
        recRate1.setText(String.valueOf(Church.churchRate[2]));
        recStatus1.setText(String.valueOf(Church.churchStatus[2]));
        if(String.valueOf(Church.churchStatus[2]).equals("true"))
        {
            recOpenStatus1.setVisible(true);
            new FadeInLeft(recOpenStatus1).setDelay(Duration.seconds(3.2)).play();
        }
        else
        {
            recCloseStatus1.setVisible(true);
            new FadeInLeft(recCloseStatus1).setDelay(Duration.seconds(3.2)).play();
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Recommended Shop 2">
        recName2.setText(Bar.barName[6]);
        recType2.setText(Bar.barType[6]);
        recRate2.setText(String.valueOf(Bar.barRate[6]));
        recStatus2.setText(String.valueOf(Bar.barStatus[6]));
        if(String.valueOf(Bar.barStatus[6]).equals("true"))
        {
            recOpenStatus1.setVisible(true);
            new FadeInLeft(recOpenStatus2).setDelay(Duration.seconds(3.2)).play();
        }
        else
        {
            recCloseStatus1.setVisible(true);
            new FadeInLeft(recCloseStatus2).setDelay(Duration.seconds(3.2)).play();
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Recommended Shop 3">
        recName3.setText(Museum.museumName[2]);
        recType3.setText(Museum.museumType[2]);
        recRate3.setText(String.valueOf(Museum.museumRate[2]));
        recStatus3.setText(String.valueOf(Museum.museumStatus[2]));
        if(String.valueOf(Museum.museumStatus[2]).equals("true"))
        {
            recOpenStatus1.setVisible(true);
            new FadeInLeft(recOpenStatus3).setDelay(Duration.seconds(3.2)).play();
        }
        else
        {
            recCloseStatus1.setVisible(true);
            new FadeInLeft(recCloseStatus3).setDelay(Duration.seconds(3.2)).play();
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Recommended Shop 4">
        recName4.setText(Restaurant.restaurantName[1]);
        recType4.setText(Restaurant.restaurantType[1]);
        recRate4.setText(String.valueOf(Restaurant.restaurantRate[1]));
        recStatus4.setText(String.valueOf(Restaurant.restaurantStatus[1]));
        if(String.valueOf(Restaurant.restaurantStatus[1]).equals("true"))
        {
            recOpenStatus1.setVisible(true);
            new FadeInLeft(recOpenStatus4).setDelay(Duration.seconds(3.2)).play();
        }
        else
        {
            recCloseStatus1.setVisible(true);
            new FadeInLeft(recCloseStatus4).setDelay(Duration.seconds(3.2)).play();
        }

        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Recommended Shop 5">
        recName5.setText(Park.parkName[10]);
        recType5.setText(Park.parkType[10]);
        recRate5.setText(String.valueOf(Park.parkRate[10]));
        recStatus5.setText(String.valueOf(Park.parkStatus[10]));
        if(String.valueOf(Park.parkStatus[10]).equals("true"))
        {
            recOpenStatus1.setVisible(true);
            new FadeInLeft(recOpenStatus5).setDelay(Duration.seconds(3.2)).play();
        }
        else
        {
            recCloseStatus1.setVisible(true);
            new FadeInLeft(recCloseStatus5).setDelay(Duration.seconds(3.2)).play();
        }
        //</editor-fold>
    }

    private void setLightMode() {
        modeButton.setOpacity(0.0);
        new RotateIn(modeButton).play();
        modeButton.setImage(new Image(getClass().getResourceAsStream("gui/light.png")));
        mainPane.getStylesheets().remove(Objects.requireNonNull(getClass().getResource("design/nightMode.css")).toExternalForm());
        mainPane.getStylesheets().add(Objects.requireNonNull(getClass().getResource("design/lightMode.css")).toExternalForm());

    }

    private void setDarkMode() {
        modeButton.setOpacity(0.0);
        new RotateIn(modeButton).play();
        modeButton.setImage(new Image(getClass().getResourceAsStream("gui/night.png")));
        modeButton.setFitWidth(30);
        modeButton.setFitWidth(30);
        mainPane.getStylesheets().remove(Objects.requireNonNull(getClass().getResource("design/lightMode.css")).toExternalForm());
        mainPane.getStylesheets().add(Objects.requireNonNull(getClass().getResource("design/nightMode.css")).toExternalForm());

    }

    public VBox populateDropDownMenu(String text, String[] options){
        for(String option : options)
        {
            if(!text.replace(" ", "").isEmpty() && option.toUpperCase().contains(text.toUpperCase())){
                Label label = new Label(option);
                label.setFont(new Font("Barlow Condensed", 35));
                searchVbox.getChildren().add(label);
                searchVbox.setLayoutX(35);
                searchVbox.setLayoutY(140);


            }
        }
        return  searchVbox;

    }


    protected Favourite setFavourite()
    {
        new BounceIn(favouriteCafe1).play();
        favouriteCafe1.setImage(new Image(getClass().getResourceAsStream("gui/favouriteFill.png")));

        final String DB_URL = "jdbc:mysql://localhost/testing?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        String name = Cafe.cafeName[0];
        String type = Cafe.cafeType[0];
        double rating = Cafe.cafeRate[0];

        Favourite favourite = null;
        String username = User.name;

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO favourite (username, name,rating,type) " +
                    "VALUES (?, ?, ?,?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, name);
            preparedStatement.setDouble(3, rating);
            preparedStatement.setString(4, type);
            preparedStatement.executeUpdate();
            //Inserting rows into the table
            int addedRows = preparedStatement.executeUpdate();
            if (addedRows > 0) {
                favourite = new Favourite();
                favourite.username = username;
                favourite.name = name;
                favourite.rating = (float) rating;
                favourite.type = type;

            }

            stmt.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
        return favourite;

    }
    private void setFavouriteFill() {
        new BounceIn(favouriteCafe1).play();
        favouriteCafe1.setImage(new Image(getClass().getResourceAsStream("gui/favourite.png")));
    }
}




















