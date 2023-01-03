package com.example.tourist_application;

import animatefx.animation.*;
import categories.*;
import javafx.animation.*;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
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
    private int favCountDown=5;
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
    private ImageView recImage5;
    @FXML
    private WebView shopWebView1;
    @FXML
    private ImageView recImage4;
    @FXML
    private ImageView recImage3;
    @FXML
    private ImageView recImage2;
    @FXML
    private AnchorPane welcomebg;
    @FXML
    private Button homeLoginButton;
    @FXML
    private PasswordField passwordPf;
    @FXML
    private Pane accessPane;
    @FXML
    private WebView shopWebView2;
    @FXML
    private WebView shopWebView3;
    @FXML
    private WebView shopWebView4;
    @FXML
    private WebView shopWebView5;
    @FXML
    private WebView shopWebView6;
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
    private Label cafeName4;
    @FXML
    private Label cafeType4;
    @FXML
    private Pane cafePane4;
    @FXML
    private Label cafeRate4;
    @FXML
    private ImageView cafeOpenStatus4;
    @FXML
    private ImageView cafeCloseStatus4;
    @FXML
    private Label cafeName5;
    @FXML
    private Label cafeType5;
    @FXML
    private Pane cafePane5;
    @FXML
    private Label cafeRate5;
    @FXML
    private ImageView cafeOpenStatus5;
    @FXML
    private ImageView cafeCloseStatus5;
    @FXML
    private Label cafeName6;
    @FXML
    private Label cafeType6;
    @FXML
    private Pane cafePane6;
    @FXML
    private Label cafeRate6;
    @FXML
    private ImageView cafeOpenStatus6;
    @FXML
    private ImageView cafeCloseStatus6;
    @FXML
    private Label cafeName7;
    @FXML
    private Label cafeType7;
    @FXML
    private Pane cafePane7;
    @FXML
    private Label cafeRate7;
    @FXML
    private ImageView cafeOpenStatus7;
    @FXML
    private ImageView cafeCloseStatus7;
    @FXML
    private Label cafeName8;
    @FXML
    private Label cafeType8;
    @FXML
    private Pane cafePane8;
    @FXML
    private Label cafeRate8;
    @FXML
    private ImageView cafeOpenStatus8;
    @FXML
    private ImageView cafeCloseStatus8;
    @FXML
    private Label cafeName9;
    @FXML
    private Label cafeType9;
    @FXML
    private Pane cafePane9;
    @FXML
    private Label cafeRate9;
    @FXML
    private ImageView cafeOpenStatus9;
    @FXML
    private ImageView cafeCloseStatus9;
    @FXML
    private Label cafeName10;
    @FXML
    private Label cafeType10;
    @FXML
    private Pane cafePane10;
    @FXML
    private Label cafeRate10;
    @FXML
    private ImageView cafeOpenStatus10;
    @FXML
    private ImageView cafeCloseStatus10;
    @FXML
    private Label cafeName11;
    @FXML
    private Label cafeType11;
    @FXML
    private Pane cafePane11;
    @FXML
    private Label cafeRate11;
    @FXML
    private ImageView cafeOpenStatus11;
    @FXML
    private ImageView cafeCloseStatus11;
    @FXML
    private Label cafeName12;
    @FXML
    private Label cafeType12;
    @FXML
    private Pane cafePane12;
    @FXML
    private Label cafeRate12;
    @FXML
    private ImageView cafeOpenStatus12;
    @FXML
    private ImageView cafeCloseStatus12;
    @FXML
    private Label cafeName13;
    @FXML
    private Label cafeType13;
    @FXML
    private Pane cafePane13;
    @FXML
    private Label cafeRate13;
    @FXML
    private ImageView cafeOpenStatus13;
    @FXML
    private ImageView cafeCloseStatus13;
    @FXML
    private Label cafeName14;
    @FXML
    private Label cafeType14;
    @FXML
    private Pane cafePane14;
    @FXML
    private Label cafeRate14;
    @FXML
    private ImageView cafeOpenStatus14;
    @FXML
    private ImageView cafeCloseStatus14;
    @FXML
    private Label cafeName15;
    @FXML
    private Label cafeType15;
    @FXML
    private Pane cafePane15;
    @FXML
    private Label cafeRate15;
    @FXML
    private ImageView cafeOpenStatus15;
    @FXML
    private ImageView cafeCloseStatus15;
    @FXML
    private Label cafeName16;
    @FXML
    private Label cafeType16;
    @FXML
    private Pane cafePane16;
    @FXML
    private Label cafeRate16;
    @FXML
    private ImageView cafeOpenStatus16;
    @FXML
    private ImageView cafeCloseStatus16;
    @FXML
    private Label cafeName17;
    @FXML
    private Label cafeType17;
    @FXML
    private Pane cafePane17;
    @FXML
    private Label cafeRate17;
    @FXML
    private ImageView cafeOpenStatus17;
    @FXML
    private ImageView cafeCloseStatus17;
    @FXML
    private Label cafeName18;
    @FXML
    private Label cafeType18;
    @FXML
    private Pane cafePane18;
    @FXML
    private Label cafeRate18;
    @FXML
    private ImageView cafeOpenStatus18;
    @FXML
    private ImageView cafeCloseStatus18;
    @FXML
    private Label cafeName19;
    @FXML
    private Label cafeType19;
    @FXML
    private Pane cafePane19;
    @FXML
    private Label cafeRate19;
    @FXML
    private ImageView cafeOpenStatus19;
    @FXML
    private ImageView cafeCloseStatus19;
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
    private Pane cafePane;
    @FXML
    private ImageView restaurantCloseStatus1;
    @FXML
    private ImageView restaurantOpenStatus1;
    @FXML
    private Label resultsRestaurant;
    @FXML
    private Pane restaurantPane;
    @FXML
    private Pane restaurantPane1;
    @FXML
    private Label restaurantName1;
    @FXML
    private Label restaurantRate1;
    @FXML
    private Label restaurantType1;
    @FXML
    private Pane restaurantPane2;
    @FXML
    private Label restaurantName2;
    @FXML
    private Label restaurantType2;
    @FXML
    private Label restaurantRate2;
    @FXML
    private ImageView restaurantOpenStatus2;
    @FXML
    private ImageView restaurantCloseStatus2;
    @FXML
    private Pane restaurantPane3;
    @FXML
    private Label restaurantName3;
    @FXML
    private Label restaurantType3;
    @FXML
    private Label restaurantRate3;
    @FXML
    private ImageView restaurantOpenStatus3;
    @FXML
    private ImageView restaurantCloseStatus3;
    @FXML
    private Pane restaurantPane4;
    @FXML
    private Label restaurantName4;
    @FXML
    private Label restaurantType4;
    @FXML
    private Label restaurantRate4;
    @FXML
    private ImageView restaurantOpenStatus4;
    @FXML
    private ImageView restaurantCloseStatus4;
    @FXML
    private Pane restaurantPane5;
    @FXML
    private Label restaurantName5;
    @FXML
    private Label restaurantType5;
    @FXML
    private Label restaurantRate5;
    @FXML
    private ImageView restaurantOpenStatus5;
    @FXML
    private ImageView restaurantCloseStatus5;
    @FXML
    private Pane restaurantPane6;
    @FXML
    private Label restaurantName6;
    @FXML
    private Label restaurantType6;
    @FXML
    private Label restaurantRate6;
    @FXML
    private ImageView restaurantOpenStatus6;
    @FXML
    private ImageView restaurantCloseStatus6;
    @FXML
    private Pane restaurantPane7;
    @FXML
    private Label restaurantName7;
    @FXML
    private Label restaurantType7;
    @FXML
    private Label restaurantRate7;
    @FXML
    private ImageView restaurantOpenStatus7;
    @FXML
    private ImageView restaurantCloseStatus7;
    @FXML
    private Pane restaurantPane8;
    @FXML
    private Label restaurantName8;
    @FXML
    private Label restaurantType8;
    @FXML
    private Label restaurantRate8;
    @FXML
    private ImageView restaurantOpenStatus8;
    @FXML
    private ImageView restaurantCloseStatus8;
    @FXML
    private Pane restaurantPane9;
    @FXML
    private Label restaurantName9;
    @FXML
    private Label restaurantType9;
    @FXML
    private Label restaurantRate9;
    @FXML
    private ImageView restaurantOpenStatus9;
    @FXML
    private ImageView restaurantCloseStatus9;
    @FXML
    private Pane restaurantPane10;
    @FXML
    private Label restaurantName10;
    @FXML
    private Label restaurantType10;
    @FXML
    private Label restaurantRate10;
    @FXML
    private ImageView restaurantOpenStatus10;
    @FXML
    private ImageView restaurantCloseStatus10;
    @FXML
    private Pane restaurantPane11;
    @FXML
    private Label restaurantName11;
    @FXML
    private Label restaurantType11;
    @FXML
    private Label restaurantRate11;
    @FXML
    private ImageView restaurantOpenStatus11;
    @FXML
    private ImageView restaurantCloseStatus11;
    @FXML
    private Pane restaurantPane12;
    @FXML
    private Label restaurantName12;
    @FXML
    private Label restaurantType12;
    @FXML
    private Label restaurantRate12;
    @FXML
    private ImageView restaurantOpenStatus12;
    @FXML
    private ImageView restaurantCloseStatus12;
    @FXML
    private Pane restaurantPane13;
    @FXML
    private Label restaurantName13;
    @FXML
    private Label restaurantType13;
    @FXML
    private Label restaurantRate13;
    @FXML
    private ImageView restaurantOpenStatus13;
    @FXML
    private ImageView restaurantCloseStatus13;
    @FXML
    private Pane restaurantPane14;
    @FXML
    private Label restaurantName14;
    @FXML
    private Label restaurantType14;
    @FXML
    private Label restaurantRate14;
    @FXML
    private ImageView restaurantOpenStatus14;
    @FXML
    private ImageView restaurantCloseStatus14;
    @FXML
    private Pane restaurantPane15;
    @FXML
    private Label restaurantName15;
    @FXML
    private Label restaurantType15;
    @FXML
    private Label restaurantRate15;
    @FXML
    private ImageView restaurantOpenStatus15;
    @FXML
    private ImageView restaurantCloseStatus15;
    @FXML
    private Pane restaurantPane16;
    @FXML
    private Label restaurantName16;
    @FXML
    private Label restaurantType16;
    @FXML
    private Label restaurantRate16;
    @FXML
    private ImageView restaurantOpenStatus16;
    @FXML
    private ImageView restaurantCloseStatus16;
    @FXML
    private Pane restaurantPane17;
    @FXML
    private Label restaurantName17;
    @FXML
    private Label restaurantType17;
    @FXML
    private Label restaurantRate17;
    @FXML
    private ImageView restaurantOpenStatus17;
    @FXML
    private ImageView restaurantCloseStatus17;
    @FXML
    private Pane restaurantPane18;
    @FXML
    private Label restaurantName18;
    @FXML
    private Label restaurantType18;
    @FXML
    private Label restaurantRate18;
    @FXML
    private ImageView restaurantOpenStatus18;
    @FXML
    private ImageView restaurantCloseStatus18;
    @FXML
    private Pane restaurantPane19;
    @FXML
    private Label restaurantName19;
    @FXML
    private Label restaurantType19;
    @FXML
    private Label restaurantRate19;
    @FXML
    private ImageView restaurantOpenStatus19;
    @FXML
    private ImageView restaurantCloseStatus19;
    @FXML
    private Pane ParkPane;
    @FXML
    private Label resultsPark;
    @FXML
    private ImageView ParkCategory;
    @FXML
    private Pane parkPane1;
    @FXML
    private Label parkName1;
    @FXML
    private Label parkType1;
    @FXML
    private Label parkRate1;
    @FXML
    private ImageView parkOpenStatus1;
    @FXML
    private ImageView parkCloseStatus1;
    @FXML
    private Pane parkPane2;
    @FXML
    private Label parkName2;
    @FXML
    private Label parkType2;
    @FXML
    private Label parkRate2;
    @FXML
    private ImageView parkOpenStatus2;
    @FXML
    private ImageView parkCloseStatus2;
    @FXML
    private Pane parkPane3;
    @FXML
    private Label parkName3;
    @FXML
    private Label parkType3;
    @FXML
    private Label parkRate3;
    @FXML
    private ImageView parkOpenStatus3;
    @FXML
    private ImageView parkCloseStatus3;
    @FXML
    private Pane parkPane4;
    @FXML
    private Label parkName4;
    @FXML
    private Label parkType4;
    @FXML
    private Label parkRate4;
    @FXML
    private ImageView parkOpenStatus4;
    @FXML
    private ImageView parkCloseStatus4;
    @FXML
    private Pane parkPane5;
    @FXML
    private Label parkName5;
    @FXML
    private Label parkType5;
    @FXML
    private Label parkRate5;
    @FXML
    private ImageView parkOpenStatus5;
    @FXML
    private ImageView parkCloseStatus5;
    @FXML
    private Pane parkPane6;
    @FXML
    private Label parkName6;
    @FXML
    private Label parkType6;
    @FXML
    private Label parkRate6;
    @FXML
    private ImageView parkOpenStatus6;
    @FXML
    private ImageView parkCloseStatus6;
    @FXML
    private Pane parkPane7;
    @FXML
    private Label parkName7;
    @FXML
    private Label parkType7;
    @FXML
    private Label parkRate7;
    @FXML
    private ImageView parkOpenStatus7;
    @FXML
    private ImageView parkCloseStatus7;
    @FXML
    private Pane parkPane8;
    @FXML
    private Label parkName8;
    @FXML
    private Label parkType8;
    @FXML
    private Label parkRate8;
    @FXML
    private ImageView parkOpenStatus8;
    @FXML
    private ImageView parkCloseStatus8;
    @FXML
    private Pane parkPane9;
    @FXML
    private Label parkName9;
    @FXML
    private Label parkType9;
    @FXML
    private Label parkRate9;
    @FXML
    private ImageView parkOpenStatus9;
    @FXML
    private ImageView parkCloseStatus9;
    @FXML
    private Pane parkPane10;
    @FXML
    private Label parkName10;
    @FXML
    private Label parkType10;
    @FXML
    private Label parkRate10;
    @FXML
    private ImageView parkOpenStatus10;
    @FXML
    private ImageView parkCloseStatus10;
    @FXML
    private Pane parkPane11;
    @FXML
    private Label parkName11;
    @FXML
    private Label parkType11;
    @FXML
    private Label parkRate11;
    @FXML
    private ImageView parkOpenStatus11;
    @FXML
    private ImageView parkCloseStatus11;
    @FXML
    private Pane parkPane12;
    @FXML
    private Label parkName12;
    @FXML
    private Label parkType12;
    @FXML
    private Label parkRate12;
    @FXML
    private ImageView parkOpenStatus12;
    @FXML
    private ImageView parkCloseStatus12;
    @FXML
    private Pane parkPane13;
    @FXML
    private Label parkName13;
    @FXML
    private Label parkType13;
    @FXML
    private Label parkRate13;
    @FXML
    private ImageView parkOpenStatus13;
    @FXML
    private ImageView parkCloseStatus13;
    @FXML
    private Pane parkPane14;
    @FXML
    private Label parkName14;
    @FXML
    private Label parkType14;
    @FXML
    private Label parkRate14;
    @FXML
    private ImageView parkOpenStatus14;
    @FXML
    private ImageView parkCloseStatus14;
    @FXML
    private Pane parkPane15;
    @FXML
    private Label parkName15;
    @FXML
    private Label parkType15;
    @FXML
    private Label parkRate15;
    @FXML
    private ImageView parkOpenStatus15;
    @FXML
    private ImageView parkCloseStatus15;
    @FXML
    private Pane parkPane16;
    @FXML
    private Label parkName16;
    @FXML
    private Label parkType16;
    @FXML
    private Label parkRate16;
    @FXML
    private ImageView parkOpenStatus16;
    @FXML
    private ImageView parkCloseStatus16;
    @FXML
    private Pane parkPane17;
    @FXML
    private Label parkName17;
    @FXML
    private Label parkType17;
    @FXML
    private Label parkRate17;
    @FXML
    private ImageView parkOpenStatus17;
    @FXML
    private ImageView parkCloseStatus17;
    @FXML
    private Pane parkPane18;
    @FXML
    private Label parkName18;
    @FXML
    private Label parkType18;
    @FXML
    private Label parkRate18;
    @FXML
    private ImageView parkOpenStatus18;
    @FXML
    private ImageView parkCloseStatus18;
    @FXML
    private Pane parkPane19;
    @FXML
    private Label parkName19;
    @FXML
    private Label parkType19;
    @FXML
    private Label parkRate19;
    @FXML
    private ImageView parkOpenStatus19;
    @FXML
    private ImageView parkCloseStatus19;
    @FXML
    private Pane parkPane20;
    @FXML
    private Label parkName20;
    @FXML
    private Label parkType20;
    @FXML
    private Label parkRate20;
    @FXML
    private ImageView parkOpenStatus20;
    @FXML
    private ImageView parkCloseStatus20;
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
    protected  void generateBlueGiakasProfile(MouseEvent event) throws IOException {
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

        final WebEngine image1 = shopWebView1.getEngine();
        final WebEngine image2 = shopWebView2.getEngine();
        final WebEngine image3 = shopWebView3.getEngine();
        final WebEngine image4 = shopWebView4.getEngine();
        final WebEngine image5 = shopWebView5.getEngine();
        final WebEngine image6 = shopWebView6.getEngine();
        String placeId = "ChIJGXx-G41xqRQRr6TPQ6pf5lo"; // Place ID gia ton mple giaka
        PhotoParser.generatePhotos(placeId);
        String photo1 = PhotoParser.photosArray[0];
        String photo2 = PhotoParser.photosArray[1];
        String photo3 = PhotoParser.photosArray[2];
        String photo4 = PhotoParser.photosArray[3];
        String photo5 = PhotoParser.photosArray[4];
        String photo6 = PhotoParser.photosArray[5];
        image1.load(photo1);
        image2.load(photo2);
        image3.load(photo3);
        image4.load(photo4);
        image5.load(photo5);
        image6.load(photo6);

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
    @FXML
    protected  void generateHayatRoofProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Cafe.cafeName[4]);
        typeProfileLabel.setText(Cafe.cafeType[4]);
        if(String.valueOf(Cafe.cafeStatus[4]).equals("true"))
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
    protected  void generateCoffeeIslandProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Cafe.cafeName[5]);
        typeProfileLabel.setText(Cafe.cafeType[5]);
        if(String.valueOf(Cafe.cafeStatus[5]).equals("true"))
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
    protected  void generateVoltaBarProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Cafe.cafeName[6]);
        typeProfileLabel.setText(Cafe.cafeType[6]);
        if(String.valueOf(Cafe.cafeStatus[6]).equals("true"))
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
    protected  void generateKennedyEspressoBarProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Cafe.cafeName[7]);
        typeProfileLabel.setText(Cafe.cafeType[7]);
        if(String.valueOf(Cafe.cafeStatus[7]).equals("true"))
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
    protected  void generateMikelCoffeeProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Cafe.cafeName[8]);
        typeProfileLabel.setText(Cafe.cafeType[8]);
        if(String.valueOf(Cafe.cafeStatus[8]).equals("true"))
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
    protected  void generateCafeBar19Profile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Cafe.cafeName[9]);
        typeProfileLabel.setText(Cafe.cafeType[9]);
        if(String.valueOf(Cafe.cafeStatus[9]).equals("true"))
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
    protected  void generateJuiceBoxNaturalBitesProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Cafe.cafeName[10]);
        typeProfileLabel.setText(Cafe.cafeType[10]);
        if(String.valueOf(Cafe.cafeStatus[10]).equals("true"))
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
    protected  void generateKouzinaBarProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Cafe.cafeName[11]);
        typeProfileLabel.setText(Cafe.cafeType[11]);
        if(String.valueOf(Cafe.cafeStatus[11]).equals("true"))
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
    protected  void generategoalcafeProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Cafe.cafeName[12]);
        typeProfileLabel.setText(Cafe.cafeType[12]);
        if(String.valueOf(Cafe.cafeStatus[12]).equals("true"))
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
    protected  void generateMeliosOilProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Cafe.cafeName[13]);
        typeProfileLabel.setText(Cafe.cafeType[13]);
        if(String.valueOf(Cafe.cafeStatus[13]).equals("true"))
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
    protected  void generateXrysoProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Cafe.cafeName[14]);
        typeProfileLabel.setText(Cafe.cafeType[14]);
        if(String.valueOf(Cafe.cafeStatus[14]).equals("true"))
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
    protected  void generateTodaysDeliciousProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Cafe.cafeName[15]);
        typeProfileLabel.setText(Cafe.cafeType[15]);
        if(String.valueOf(Cafe.cafeStatus[15]).equals("true"))
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
    protected  void generateToSpitikoProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Cafe.cafeName[16]);
        typeProfileLabel.setText(Cafe.cafeType[16]);
        if(String.valueOf(Cafe.cafeStatus[16]).equals("true"))
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
    protected  void generateTheCoffeeStore2Profile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Cafe.cafeName[17]);
        typeProfileLabel.setText(Cafe.cafeType[17]);
        if(String.valueOf(Cafe.cafeStatus[17]).equals("true"))
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
    protected  void generateCityZenProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Cafe.cafeName[18]);
        typeProfileLabel.setText(Cafe.cafeType[18]);
        if(String.valueOf(Cafe.cafeStatus[18]).equals("true"))
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
    protected  void generateTheCoffeeStoreProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Cafe.cafeName[19]);
        typeProfileLabel.setText(Cafe.cafeType[19]);
        if(String.valueOf(Cafe.cafeStatus[19]).equals("true"))
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

    //</editor-fold

    //<editor-fold default-state="collapsed" desc=" Restaurant Profiles ">
    @FXML
    protected  void generateMonopolionKathodonProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Restaurant.restaurantName[0]);
        typeProfileLabel.setText(Restaurant.restaurantType[0]);
        if(String.valueOf(Restaurant.restaurantStatus[0]).equals("true"))
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
    protected  void generateMasisetoProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/caffettieri/profile.png")));
        nameProfileLabel.setText(Restaurant.restaurantName[1]);
        typeProfileLabel.setText(Restaurant.restaurantType[1]);
        if(String.valueOf(Restaurant.restaurantStatus[1]).equals("true"))
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
    protected  void generatePsitopoleioPallikarisProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/voice_espresso/profile.png")));
        nameProfileLabel.setText(Restaurant.restaurantName[2]);
        typeProfileLabel.setText(Restaurant.restaurantType[2]);
        if(String.valueOf(Restaurant.restaurantStatus[2]).equals("true"))
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
    @FXML
    protected  void generatePsitopoleioAulogirosProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/voice_espresso/profile.png")));
        nameProfileLabel.setText(Restaurant.restaurantName[3]);
        typeProfileLabel.setText(Restaurant.restaurantType[3]);
        if(String.valueOf(Restaurant.restaurantStatus[3]).equals("true"))
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
    @FXML
    protected  void generateMprikiHomebarandgrillProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/voice_espresso/profile.png")));
        nameProfileLabel.setText(Restaurant.restaurantName[4]);
        typeProfileLabel.setText(Restaurant.restaurantType[4]);
        if(String.valueOf(Restaurant.restaurantStatus[4]).equals("true"))
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
    @FXML
    protected  void generateOKaliterosProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/voice_espresso/profile.png")));
        nameProfileLabel.setText(Restaurant.restaurantName[5]);
        typeProfileLabel.setText(Restaurant.restaurantType[5]);
        if(String.valueOf(Restaurant.restaurantStatus[5]).equals("true"))
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
    @FXML
    protected  void generateSpecialProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/voice_espresso/profile.png")));
        nameProfileLabel.setText(Restaurant.restaurantName[6]);
        typeProfileLabel.setText(Restaurant.restaurantType[6]);
        if(String.valueOf(Restaurant.restaurantStatus[6]).equals("true"))
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
    @FXML
    protected  void generateHayatRoofRestProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/voice_espresso/profile.png")));
        nameProfileLabel.setText(Restaurant.restaurantName[7]);
        typeProfileLabel.setText(Restaurant.restaurantType[7]);
        if(String.valueOf(Restaurant.restaurantStatus[7]).equals("true"))
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
    @FXML
    protected  void generateTheMeatHouseProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/voice_espresso/profile.png")));
        nameProfileLabel.setText(Restaurant.restaurantName[8]);
        typeProfileLabel.setText(Restaurant.restaurantType[8]);
        if(String.valueOf(Restaurant.restaurantStatus[8]).equals("true"))
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
    @FXML
    protected  void generateGiroGiroOloiProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/voice_espresso/profile.png")));
        nameProfileLabel.setText(Restaurant.restaurantName[9]);
        typeProfileLabel.setText(Restaurant.restaurantType[9]);
        if(String.valueOf(Restaurant.restaurantStatus[9]).equals("true"))
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
    @FXML
    protected  void generateKennedyEspressoBarRestProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/voice_espresso/profile.png")));
        nameProfileLabel.setText(Restaurant.restaurantName[10]);
        typeProfileLabel.setText(Restaurant.restaurantType[10]);
        if(String.valueOf(Restaurant.restaurantStatus[10]).equals("true"))
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
    @FXML
    protected  void generateTramCafeSerresProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/voice_espresso/profile.png")));
        nameProfileLabel.setText(Restaurant.restaurantName[11]);
        typeProfileLabel.setText(Restaurant.restaurantType[11]);
        if(String.valueOf(Restaurant.restaurantStatus[11]).equals("true"))
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
    @FXML
    protected  void generateOSotosProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/voice_espresso/profile.png")));
        nameProfileLabel.setText(Restaurant.restaurantName[12]);
        typeProfileLabel.setText(Restaurant.restaurantType[12]);
        if(String.valueOf(Restaurant.restaurantStatus[12]).equals("true"))
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
    @FXML
    protected  void generateMpougatsaRekorProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/voice_espresso/profile.png")));
        nameProfileLabel.setText(Restaurant.restaurantName[13]);
        typeProfileLabel.setText(Restaurant.restaurantType[13]);
        if(String.valueOf(Restaurant.restaurantStatus[13]).equals("true"))
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
    @FXML
    protected  void generateKouzinaBarRestProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/voice_espresso/profile.png")));
        nameProfileLabel.setText(Restaurant.restaurantName[14]);
        typeProfileLabel.setText(Restaurant.restaurantType[14]);
        if(String.valueOf(Restaurant.restaurantStatus[14]).equals("true"))
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
    @FXML
    protected  void generatePsitopolioOKostasProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/voice_espresso/profile.png")));
        nameProfileLabel.setText(Restaurant.restaurantName[15]);
        typeProfileLabel.setText(Restaurant.restaurantType[15]);
        if(String.valueOf(Restaurant.restaurantStatus[15]).equals("true"))
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
    @FXML
    protected  void generateTodaysDeliciousRestProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/voice_espresso/profile.png")));
        nameProfileLabel.setText(Restaurant.restaurantName[16]);
        typeProfileLabel.setText(Restaurant.restaurantType[16]);
        if(String.valueOf(Restaurant.restaurantStatus[16]).equals("true"))
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
    @FXML
    protected  void generateKappariProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/voice_espresso/profile.png")));
        nameProfileLabel.setText(Restaurant.restaurantName[17]);
        typeProfileLabel.setText(Restaurant.restaurantType[17]);
        if(String.valueOf(Restaurant.restaurantStatus[17]).equals("true"))
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
    @FXML
    protected  void generateToSpitikoRestProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/voice_espresso/profile.png")));
        nameProfileLabel.setText(Restaurant.restaurantName[18]);
        typeProfileLabel.setText(Restaurant.restaurantType[18]);
        if(String.valueOf(Restaurant.restaurantStatus[18]).equals("true"))
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


    //</editor-fold

    //<editor-fold default-state="collapsed" desc=" Park Profiles ">
    @FXML
    protected  void generateMonumentCaptainMitrousisProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Park.parkName[0]);
        typeProfileLabel.setText(Park.parkType[0]);
        if(String.valueOf(Park.parkStatus[0]).equals("true"))
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
    protected  void generateTRIKALAProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Park.parkName[1]);
        typeProfileLabel.setText(Park.parkType[1]);
        if(String.valueOf(Park.parkStatus[1]).equals("true"))
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
    protected  void generatePlateiaKonstantinouKabafiProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Park.parkName[2]);
        typeProfileLabel.setText(Park.parkType[2]);
        if(String.valueOf(Park.parkStatus[2]).equals("true"))
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
    protected  void generateRodosbeatsProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Park.parkName[3]);
        typeProfileLabel.setText(Park.parkType[3]);
        if(String.valueOf(Park.parkStatus[3]).equals("true"))
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
    protected  void generatePlateiaKroniouProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Park.parkName[4]);
        typeProfileLabel.setText(Park.parkType[4]);
        if(String.valueOf(Park.parkStatus[4]).equals("true"))
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
    protected  void generateAgalmaAnastasiouPolizoidiProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Park.parkName[5]);
        typeProfileLabel.setText(Park.parkType[5]);
        if(String.valueOf(Park.parkStatus[5]).equals("true"))
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
    protected  void generateTriaSintribaniaProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Park.parkName[6]);
        typeProfileLabel.setText(Park.parkType[6]);
        if(String.valueOf(Park.parkStatus[6]).equals("true"))
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
    protected  void generateLibertySquareProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Park.parkName[7]);
        typeProfileLabel.setText(Park.parkType[7]);
        if(String.valueOf(Park.parkStatus[7]).equals("true"))
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
    protected  void generateParkFormerProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Park.parkName[8]);
        typeProfileLabel.setText(Park.parkType[8]);
        if(String.valueOf(Park.parkStatus[8]).equals("true"))
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
    protected  void generateParkSerresProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Park.parkName[9]);
        typeProfileLabel.setText(Park.parkType[9]);
        if(String.valueOf(Park.parkStatus[9]).equals("true"))
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
    protected  void generateAnoikto8eatrakiProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Park.parkName[10]);
        typeProfileLabel.setText(Park.parkType[10]);
        if(String.valueOf(Park.parkStatus[10]).equals("true"))
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
    protected  void generateMnimeioE8nikisAntistasisProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Park.parkName[11]);
        typeProfileLabel.setText(Park.parkType[11]);
        if(String.valueOf(Park.parkStatus[11]).equals("true"))
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
    protected  void generatePlateiaEmporeiouProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Park.parkName[12]);
        typeProfileLabel.setText(Park.parkType[12]);
        if(String.valueOf(Park.parkStatus[12]).equals("true"))
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
    protected  void generateAgalmaDoukaProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Park.parkName[13]);
        typeProfileLabel.setText(Park.parkType[13]);
        if(String.valueOf(Park.parkStatus[13]).equals("true"))
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
    protected  void generateProtomiDimitriouMisirliProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Park.parkName[14]);
        typeProfileLabel.setText(Park.parkType[14]);
        if(String.valueOf(Park.parkStatus[14]).equals("true"))
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
    protected  void generatePublicSquareProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Park.parkName[15]);
        typeProfileLabel.setText(Park.parkType[15]);
        if(String.valueOf(Park.parkStatus[15]).equals("true"))
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
    protected  void generateBoreioanatolikiPleuraparkouIKAProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Park.parkName[16]);
        typeProfileLabel.setText(Park.parkType[16]);
        if(String.valueOf(Park.parkStatus[16]).equals("true"))
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
    protected  void generateProtomiPasxaliTsiagkaProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Park.parkName[17]);
        typeProfileLabel.setText(Park.parkType[17]);
        if(String.valueOf(Park.parkStatus[17]).equals("true"))
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
    protected  void generateParkakiSidirokastrouBourlonProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Park.parkName[18]);
        typeProfileLabel.setText(Park.parkType[18]);
        if(String.valueOf(Park.parkStatus[18]).equals("true"))
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
    protected  void generatePlateiaProfitiHliaProfile(MouseEvent event) {
        profilePane.setVisible(true);
        new FadeIn(profilePane).play();
        profileImage.setImage(new Image(getClass().getResourceAsStream("gui/cafe/ble_giakas/profile.png")));
        nameProfileLabel.setText(Park.parkName[19]);
        typeProfileLabel.setText(Park.parkType[19]);
        if(String.valueOf(Park.parkStatus[19]).equals("true"))
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

    //</editor-fold

    //<editor-fold default-state="collapsed" desc=" PanelAnimations">
    @FXML
    protected void  enteredCategoryAnimation(MouseEvent event){
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
    protected void  enteredCoffeeCategoryAnimation(MouseEvent event)
    {
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(coffeeCategory);
        scaleTransition.setDuration(Duration.millis(300));
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.play();
    }
    @FXML
    protected void  exitedCoffeeCategoryAnimation(MouseEvent event)
    {
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(coffeeCategory);
        scaleTransition.setDuration(Duration.millis(300));
        scaleTransition.setFromX(1.1);
        scaleTransition.setFromY(1.1);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.play();
    }
    @FXML
    protected void  enteredParksCategoryAnimation(MouseEvent event)
    {
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(parksCategory);
        scaleTransition.setDuration(Duration.millis(300));
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.play();
    }
    @FXML
    protected void  exitedParksCategoryAnimation(MouseEvent event)
    {
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(parksCategory);
        scaleTransition.setDuration(Duration.millis(300));
        scaleTransition.setFromX(1.1);
        scaleTransition.setFromY(1.1);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.play();
    }
    @FXML
    protected void  enteredNightCategoryAnimation(MouseEvent event)
    {
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(nightCategory);
        scaleTransition.setDuration(Duration.millis(300));
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.play();
    }
    @FXML
    protected void  exitedNightCategoryAnimation(MouseEvent event)
    {
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(nightCategory);
        scaleTransition.setDuration(Duration.millis(300));
        scaleTransition.setFromX(1.1);
        scaleTransition.setFromY(1.1);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.play();
    }
    @FXML
    protected void  enteredMuseumsCategoryAnimation(MouseEvent event)
    {
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(musuemsCategory);
        scaleTransition.setDuration(Duration.millis(300));
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.play();
    }
    @FXML
    protected void  exitedMuseumsCategoryAnimation(MouseEvent event)
    {
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(musuemsCategory);
        scaleTransition.setDuration(Duration.millis(300));
        scaleTransition.setFromX(1.1);
        scaleTransition.setFromY(1.1);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.play();
    }
    @FXML
    protected void  enteredChurchCategoryAnimation(MouseEvent event)
    {
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(churchCategory);
        scaleTransition.setDuration(Duration.millis(300));
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.play();
    }
    @FXML
    protected void  exitedChurchCategoryAnimation(MouseEvent event)
    {
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(churchCategory);
        scaleTransition.setDuration(Duration.millis(300));
        scaleTransition.setFromX(1.1);
        scaleTransition.setFromY(1.1);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.play();
    }
    //</editor-fold
    //<editor-fold default-state="collapsed" desc=" RecPanelAnimations">
    @FXML
    protected void  enteredRec1CategoryAnimation(MouseEvent event)
    {
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(recPanel1);
        scaleTransition.setDuration(Duration.millis(300));
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.play();
    }
    @FXML
    protected void  exitedRec1CategoryAnimation(MouseEvent event)
    {
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(recPanel1);
        scaleTransition.setDuration(Duration.millis(300));
        scaleTransition.setFromX(1.1);
        scaleTransition.setFromY(1.1);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.play();
    }
    //</editor-fold


    @FXML
    protected void showSearchPanel(ActionEvent event)
    {
        //populateDropDownMenu(searchTextBox.getText(), options);
        searchResultsPanel.setVisible(true);
        searchResultsPanel.setOpacity(0.0);
        new FadeIn(searchResultsPanel).play();
    }

    @FXML
    protected void hideSearchPanel(KeyEvent event)
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
            homeLoginButton.setVisible(false);
        }
    }
    @FXML
    protected void guestEnterEvent(ActionEvent event)
    {
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
    protected void loadLoginForm(ActionEvent event){
        if(user.name == null)
        {
            loginAnchorPane.setVisible(true);
        }
    }
    @FXML
    protected void coffeeCategoryClose(MouseEvent event){

        cafeScrollPane.setVisible(false);
        homeScrollPane.setVisible(true);
    }
    @FXML
    protected void restaurantCategoryClose(MouseEvent event){

        cafeScrollPane.setVisible(false);
        homeScrollPane.setVisible(true);
    }
    @FXML
    protected void parkCategoryClose(MouseEvent event){

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
        cafePane.setVisible(true);
        restaurantPane.setVisible(false);
        ParkPane.setVisible(false);
        cafeScrollPane.setVisible(true);

        cafePane.setOpacity(0.0);
        new FadeIn(cafePane).play();

        GenerateCafe();

    }
    @FXML
    protected void foodCategoryClick(MouseEvent event){

        //ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(300), foodCategory);
        //scaleTransition.setNode(coffeeCategory);

        //scaleTransition.setFromX(1);
        //scaleTransition.setFromY(1);
        //scaleTransition.setToX(0.95);
        //scaleTransition.setToY(0.95);
        //scaleTransition.setAutoReverse(true);

        //scaleTransition.play();


        homeScrollPane.setVisible(false);
        cafePane.setVisible(false);
        ParkPane.setVisible(false);
        cafeScrollPane.setVisible(true);


        restaurantPane.setOpacity(0.0);
        new FadeIn(restaurantPane).play();
        restaurantPane.setVisible(true);

        GenerateFood();

    }
    @FXML
    protected void parkCategoryClick(MouseEvent event){

        //ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(300), foodCategory);
        //scaleTransition.setNode(coffeeCategory);

        //scaleTransition.setFromX(1);
        //scaleTransition.setFromY(1);
        //scaleTransition.setToX(0.95);
        //scaleTransition.setToY(0.95);
        //scaleTransition.setAutoReverse(true);

        //scaleTransition.play();


        homeScrollPane.setVisible(false);
        cafePane.setVisible(false);
        restaurantPane.setVisible(false);
        cafeScrollPane.setVisible(true);


        ParkPane.setOpacity(0.0);
        new FadeIn(ParkPane).play();
        ParkPane.setVisible(true);

        GeneratePark();

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

        //<editor-fold default-state="collapsed" desc=" Cafe Status ">
        cafeOpenStatus1.setVisible(false);
        cafeCloseStatus1.setVisible(false);
        cafeOpenStatus2.setVisible(false);
        cafeCloseStatus2.setVisible(false);
        cafeOpenStatus3.setVisible(false);
        cafeCloseStatus3.setVisible(false);
        cafeOpenStatus4.setVisible(false);
        cafeCloseStatus4.setVisible(false);
        cafeOpenStatus5.setVisible(false);
        cafeCloseStatus5.setVisible(false);
        cafeOpenStatus6.setVisible(false);
        cafeCloseStatus6.setVisible(false);
        cafeOpenStatus7.setVisible(false);
        cafeCloseStatus7.setVisible(false);
        cafeOpenStatus8.setVisible(false);
        cafeCloseStatus8.setVisible(false);
        cafeOpenStatus9.setVisible(false);
        cafeCloseStatus9.setVisible(false);
        cafeOpenStatus10.setVisible(false);
        cafeCloseStatus10.setVisible(false);
        cafeOpenStatus11.setVisible(false);
        cafeCloseStatus11.setVisible(false);
        cafeOpenStatus12.setVisible(false);
        cafeCloseStatus12.setVisible(false);
        cafeOpenStatus13.setVisible(false);
        cafeCloseStatus13.setVisible(false);
        cafeOpenStatus14.setVisible(false);
        cafeCloseStatus14.setVisible(false);
        cafeOpenStatus15.setVisible(false);
        cafeCloseStatus15.setVisible(false);
        cafeOpenStatus16.setVisible(false);
        cafeCloseStatus16.setVisible(false);
        cafeOpenStatus17.setVisible(false);
        cafeCloseStatus17.setVisible(false);
        cafeOpenStatus18.setVisible(false);
        cafeCloseStatus18.setVisible(false);
        cafeOpenStatus19.setVisible(false);
        cafeCloseStatus19.setVisible(false);
        //</editor-fold

        //<editor-fold default-state="collapsed" desc=" Restaurant Status ">
        restaurantOpenStatus1.setVisible(false);
        restaurantCloseStatus1.setVisible(false);
        restaurantOpenStatus2.setVisible(false);
        restaurantCloseStatus2.setVisible(false);
        restaurantOpenStatus3.setVisible(false);
        restaurantCloseStatus3.setVisible(false);
        restaurantOpenStatus4.setVisible(false);
        restaurantCloseStatus4.setVisible(false);
        restaurantOpenStatus5.setVisible(false);
        restaurantCloseStatus5.setVisible(false);
        restaurantOpenStatus6.setVisible(false);
        restaurantCloseStatus6.setVisible(false);
        restaurantOpenStatus7.setVisible(false);
        restaurantCloseStatus7.setVisible(false);
        restaurantOpenStatus8.setVisible(false);
        restaurantCloseStatus8.setVisible(false);
        restaurantOpenStatus9.setVisible(false);
        restaurantCloseStatus9.setVisible(false);
        restaurantOpenStatus10.setVisible(false);
        restaurantCloseStatus10.setVisible(false);
        restaurantOpenStatus11.setVisible(false);
        restaurantCloseStatus11.setVisible(false);
        restaurantOpenStatus12.setVisible(false);
        restaurantCloseStatus12.setVisible(false);
        restaurantOpenStatus13.setVisible(false);
        restaurantCloseStatus13.setVisible(false);
        restaurantOpenStatus14.setVisible(false);
        restaurantCloseStatus14.setVisible(false);
        restaurantOpenStatus15.setVisible(false);
        restaurantCloseStatus15.setVisible(false);
        restaurantOpenStatus16.setVisible(false);
        restaurantCloseStatus16.setVisible(false);
        restaurantOpenStatus17.setVisible(false);
        restaurantCloseStatus17.setVisible(false);
        restaurantOpenStatus18.setVisible(false);
        restaurantCloseStatus18.setVisible(false);
        restaurantOpenStatus19.setVisible(false);
        restaurantCloseStatus19.setVisible(false);
        //</editor-fold

        //<editor-fold default-state="collapsed" desc=" Park Status ">
        parkOpenStatus1.setVisible(false);
        parkCloseStatus1.setVisible(false);
        parkOpenStatus2.setVisible(false);
        parkCloseStatus2.setVisible(false);
        parkOpenStatus3.setVisible(false);
        parkCloseStatus3.setVisible(false);
        parkOpenStatus4.setVisible(false);
        parkCloseStatus4.setVisible(false);
        parkOpenStatus5.setVisible(false);
        parkCloseStatus5.setVisible(false);
        parkOpenStatus6.setVisible(false);
        parkCloseStatus6.setVisible(false);
        parkOpenStatus7.setVisible(false);
        parkCloseStatus7.setVisible(false);
        parkOpenStatus8.setVisible(false);
        parkCloseStatus8.setVisible(false);
        parkOpenStatus9.setVisible(false);
        parkCloseStatus9.setVisible(false);
        parkOpenStatus10.setVisible(false);
        parkCloseStatus10.setVisible(false);
        parkOpenStatus11.setVisible(false);
        parkCloseStatus11.setVisible(false);
        parkOpenStatus12.setVisible(false);
        parkCloseStatus12.setVisible(false);
        parkOpenStatus13.setVisible(false);
        parkCloseStatus13.setVisible(false);
        parkOpenStatus14.setVisible(false);
        parkCloseStatus14.setVisible(false);
        parkOpenStatus15.setVisible(false);
        parkCloseStatus15.setVisible(false);
        parkOpenStatus16.setVisible(false);
        parkCloseStatus16.setVisible(false);
        parkOpenStatus17.setVisible(false);
        parkCloseStatus17.setVisible(false);
        parkOpenStatus18.setVisible(false);
        parkCloseStatus18.setVisible(false);
        parkOpenStatus19.setVisible(false);
        parkCloseStatus19.setVisible(false);
        parkOpenStatus20.setVisible(false);
        parkCloseStatus20.setVisible(false);
        //</editor-fold

        //Cafe Initializer
        cafeScrollPane.setVisible(false);
        resultsCafe.setText(String.valueOf(Cafe.cafeCounter) + " results" );
        //Restaurant Initializer
        resultsRestaurant.setText(String.valueOf(Restaurant.restaurantCounter) + " results" );

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
        //<editor-fold default-state="collapsed" desc="Cafe 4">
        cafePane4.setOpacity(0.0);
        new ZoomIn(cafePane4).setDelay(Duration.seconds(0.5)).play();
        cafeName4.setText(Cafe.cafeName[3]);
        cafeType4.setText(Cafe.cafeType[3]);
        cafeRate4.setText(String.valueOf(Cafe.cafeRate[3]));
        if(String.valueOf(Cafe.cafeStatus[3]).equals("true"))
        {
            cafeOpenStatus4.setVisible(true);
        }
        else
        {
            cafeCloseStatus4.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Cafe 5">
        cafePane5.setOpacity(0.0);
        new ZoomIn(cafePane5).setDelay(Duration.seconds(0.5)).play();
        cafeName5.setText(Cafe.cafeName[4]);
        cafeType5.setText(Cafe.cafeType[4]);
        cafeRate5.setText(String.valueOf(Cafe.cafeRate[4]));
        if(String.valueOf(Cafe.cafeStatus[4]).equals("true"))
        {
            cafeOpenStatus5.setVisible(true);
        }
        else
        {
            cafeCloseStatus5.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Cafe 6">
        cafePane6.setOpacity(0.0);
        new ZoomIn(cafePane6).setDelay(Duration.seconds(0.5)).play();
        cafeName6.setText(Cafe.cafeName[5]);
        cafeType6.setText(Cafe.cafeType[5]);
        cafeRate6.setText(String.valueOf(Cafe.cafeRate[5]));
        if(String.valueOf(Cafe.cafeStatus[5]).equals("true"))
        {
            cafeOpenStatus6.setVisible(true);
        }
        else
        {
            cafeCloseStatus6.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Cafe 7">
        cafePane7.setOpacity(0.0);
        new ZoomIn(cafePane7).setDelay(Duration.seconds(0.5)).play();
        cafeName7.setText(Cafe.cafeName[6]);
        cafeType7.setText(Cafe.cafeType[6]);
        cafeRate7.setText(String.valueOf(Cafe.cafeRate[6]));
        if(String.valueOf(Cafe.cafeStatus[6]).equals("true"))
        {
            cafeOpenStatus7.setVisible(true);
        }
        else
        {
            cafeCloseStatus7.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Cafe 8">
        cafePane8.setOpacity(0.0);
        new ZoomIn(cafePane8).setDelay(Duration.seconds(0.5)).play();
        cafeName8.setText(Cafe.cafeName[7]);
        cafeType8.setText(Cafe.cafeType[7]);
        cafeRate8.setText(String.valueOf(Cafe.cafeRate[7]));
        if(String.valueOf(Cafe.cafeStatus[7]).equals("true"))
        {
            cafeOpenStatus8.setVisible(true);
        }
        else
        {
            cafeCloseStatus8.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Cafe 9">
        cafePane9.setOpacity(0.0);
        new ZoomIn(cafePane9).setDelay(Duration.seconds(0.5)).play();
        cafeName9.setText(Cafe.cafeName[9]);
        cafeType9.setText(Cafe.cafeType[9]);
        cafeRate9.setText(String.valueOf(Cafe.cafeRate[9]));
        if(String.valueOf(Cafe.cafeStatus[9]).equals("true"))
        {
            cafeOpenStatus9.setVisible(true);
        }
        else
        {
            cafeCloseStatus9.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Cafe 10">
        cafePane10.setOpacity(0.0);
        new ZoomIn(cafePane10).setDelay(Duration.seconds(0.5)).play();
        cafeName10.setText(Cafe.cafeName[10]);
        cafeType10.setText(Cafe.cafeType[10]);
        cafeRate10.setText(String.valueOf(Cafe.cafeRate[10]));
        if(String.valueOf(Cafe.cafeStatus[10]).equals("true"))
        {
            cafeOpenStatus10.setVisible(true);
        }
        else
        {
            cafeCloseStatus10.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Cafe 11">
        cafePane11.setOpacity(0.0);
        new ZoomIn(cafePane11).setDelay(Duration.seconds(0.5)).play();
        cafeName11.setText(Cafe.cafeName[11]);
        cafeType11.setText(Cafe.cafeType[11]);
        cafeRate11.setText(String.valueOf(Cafe.cafeRate[11]));
        if(String.valueOf(Cafe.cafeStatus[11]).equals("true"))
        {
            cafeOpenStatus11.setVisible(true);
        }
        else
        {
            cafeCloseStatus11.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Cafe 12">
        cafePane12.setOpacity(0.0);
        new ZoomIn(cafePane12).setDelay(Duration.seconds(0.5)).play();
        cafeName12.setText(Cafe.cafeName[12]);
        cafeType12.setText(Cafe.cafeType[12]);
        cafeRate12.setText(String.valueOf(Cafe.cafeRate[12]));
        if(String.valueOf(Cafe.cafeStatus[12]).equals("true"))
        {
            cafeOpenStatus12.setVisible(true);
        }
        else
        {
            cafeCloseStatus12.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Cafe 13">
        cafePane13.setOpacity(0.0);
        new ZoomIn(cafePane13).setDelay(Duration.seconds(0.5)).play();
        cafeName13.setText(Cafe.cafeName[13]);
        cafeType13.setText(Cafe.cafeType[13]);
        cafeRate13.setText(String.valueOf(Cafe.cafeRate[13]));
        if(String.valueOf(Cafe.cafeStatus[13]).equals("true"))
        {
            cafeOpenStatus13.setVisible(true);
        }
        else
        {
            cafeCloseStatus13.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Cafe 14">
        cafePane14.setOpacity(0.0);
        new ZoomIn(cafePane14).setDelay(Duration.seconds(0.5)).play();
        cafeName14.setText(Cafe.cafeName[14]);
        cafeType14.setText(Cafe.cafeType[14]);
        cafeRate14.setText(String.valueOf(Cafe.cafeRate[14]));
        if(String.valueOf(Cafe.cafeStatus[14]).equals("true"))
        {
            cafeOpenStatus14.setVisible(true);
        }
        else
        {
            cafeCloseStatus14.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Cafe 15">
        cafePane15.setOpacity(0.0);
        new ZoomIn(cafePane15).setDelay(Duration.seconds(0.5)).play();
        cafeName15.setText(Cafe.cafeName[15]);
        cafeType15.setText(Cafe.cafeType[15]);
        cafeRate15.setText(String.valueOf(Cafe.cafeRate[15]));
        if(String.valueOf(Cafe.cafeStatus[15]).equals("true"))
        {
            cafeOpenStatus15.setVisible(true);
        }
        else
        {
            cafeCloseStatus15.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Cafe 16">
        cafePane16.setOpacity(0.0);
        new ZoomIn(cafePane16).setDelay(Duration.seconds(0.5)).play();
        cafeName16.setText(Cafe.cafeName[16]);
        cafeType16.setText(Cafe.cafeType[16]);
        cafeRate16.setText(String.valueOf(Cafe.cafeRate[16]));
        if(String.valueOf(Cafe.cafeStatus[16]).equals("true"))
        {
            cafeOpenStatus16.setVisible(true);
        }
        else
        {
            cafeCloseStatus16.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Cafe 17">
        cafePane17.setOpacity(0.0);
        new ZoomIn(cafePane17).setDelay(Duration.seconds(0.5)).play();
        cafeName17.setText(Cafe.cafeName[17]);
        cafeType17.setText(Cafe.cafeType[17]);
        cafeRate17.setText(String.valueOf(Cafe.cafeRate[17]));
        if(String.valueOf(Cafe.cafeStatus[17]).equals("true"))
        {
            cafeOpenStatus17.setVisible(true);
        }
        else
        {
            cafeCloseStatus17.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Cafe 18">
        cafePane18.setOpacity(0.0);
        new ZoomIn(cafePane18).setDelay(Duration.seconds(0.5)).play();
        cafeName18.setText(Cafe.cafeName[18]);
        cafeType18.setText(Cafe.cafeType[18]);
        cafeRate18.setText(String.valueOf(Cafe.cafeRate[18]));
        if(String.valueOf(Cafe.cafeStatus[18]).equals("true"))
        {
            cafeOpenStatus18.setVisible(true);
        }
        else
        {
            cafeCloseStatus18.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Cafe 19">
        cafePane19.setOpacity(0.0);
        new ZoomIn(cafePane19).setDelay(Duration.seconds(0.5)).play();
        cafeName19.setText(Cafe.cafeName[19]);
        cafeType19.setText(Cafe.cafeType[19]);
        cafeRate19.setText(String.valueOf(Cafe.cafeRate[19]));
        if(String.valueOf(Cafe.cafeStatus[19]).equals("true"))
        {
            cafeOpenStatus19.setVisible(true);
        }
        else
        {
            cafeCloseStatus19.setVisible(true);
        }
        //</editor-fold>


    }
    public void GenerateFood()
    {
        //<editor-fold default-state="collapsed" desc="Restaurant 1">
        restaurantPane1.setOpacity(0.0);
        new ZoomIn(restaurantPane1).setDelay(Duration.seconds(0.5)).play();
        restaurantName1.setText(Restaurant.restaurantName[0]);
        restaurantType1.setText(Restaurant.restaurantType[0]);
        restaurantRate1.setText(String.valueOf(Restaurant.restaurantRate[0]));
        if(String.valueOf(Restaurant.restaurantStatus[0]).equals("true"))
        {
            restaurantOpenStatus1.setVisible(true);
        }
        else
        {
            restaurantCloseStatus1.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Restaurant 2">
        restaurantPane2.setOpacity(0.0);
        new ZoomIn(restaurantPane2).setDelay(Duration.seconds(0.5)).play();
        restaurantName2.setText(Restaurant.restaurantName[1]);
        restaurantType2.setText(Restaurant.restaurantType[1]);
        restaurantRate2.setText(String.valueOf(Restaurant.restaurantRate[1]));
        if(String.valueOf(Restaurant.restaurantStatus[1]).equals("true"))
        {
            restaurantOpenStatus2.setVisible(true);
        }
        else
        {
            restaurantCloseStatus2.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Restaurant 3">
        restaurantPane3.setOpacity(0.0);
        new ZoomIn(restaurantPane3).setDelay(Duration.seconds(0.5)).play();
        restaurantName3.setText(Restaurant.restaurantName[2]);
        restaurantType3.setText(Restaurant.restaurantType[2]);
        restaurantRate3.setText(String.valueOf(Restaurant.restaurantRate[2]));
        if(String.valueOf(Restaurant.restaurantStatus[2]).equals("true"))
        {
            restaurantOpenStatus3.setVisible(true);
        }
        else
        {
            restaurantCloseStatus3.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Restaurant 4">
        restaurantPane4.setOpacity(0.0);
        new ZoomIn(restaurantPane4).setDelay(Duration.seconds(0.5)).play();
        restaurantName4.setText(Restaurant.restaurantName[3]);
        restaurantType4.setText(Restaurant.restaurantType[3]);
        restaurantRate4.setText(String.valueOf(Restaurant.restaurantRate[3]));
        if(String.valueOf(Restaurant.restaurantStatus[3]).equals("true"))
        {
            restaurantOpenStatus4.setVisible(true);
        }
        else
        {
            restaurantCloseStatus4.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Restaurant 5">
        restaurantPane5.setOpacity(0.0);
        new ZoomIn(restaurantPane5).setDelay(Duration.seconds(0.5)).play();
        restaurantName5.setText(Restaurant.restaurantName[4]);
        restaurantType5.setText(Restaurant.restaurantType[4]);
        restaurantRate5.setText(String.valueOf(Restaurant.restaurantRate[4]));
        if(String.valueOf(Restaurant.restaurantStatus[4]).equals("true"))
        {
            restaurantOpenStatus5.setVisible(true);
        }
        else
        {
            restaurantCloseStatus5.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Restaurant 6">
        restaurantPane6.setOpacity(0.0);
        new ZoomIn(restaurantPane6).setDelay(Duration.seconds(0.5)).play();
        restaurantName6.setText(Restaurant.restaurantName[5]);
        restaurantType6.setText(Restaurant.restaurantType[5]);
        restaurantRate6.setText(String.valueOf(Restaurant.restaurantRate[5]));
        if(String.valueOf(Restaurant.restaurantStatus[5]).equals("true"))
        {
            restaurantOpenStatus6.setVisible(true);
        }
        else
        {
            restaurantCloseStatus6.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Restaurant 7">
        restaurantPane7.setOpacity(0.0);
        new ZoomIn(restaurantPane7).setDelay(Duration.seconds(0.5)).play();
        restaurantName7.setText(Restaurant.restaurantName[6]);
        restaurantType7.setText(Restaurant.restaurantType[6]);
        restaurantRate7.setText(String.valueOf(Restaurant.restaurantRate[6]));
        if(String.valueOf(Restaurant.restaurantStatus[6]).equals("true"))
        {
            restaurantOpenStatus7.setVisible(true);
        }
        else
        {
            restaurantCloseStatus7.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Restaurant 8">
        restaurantPane8.setOpacity(0.0);
        new ZoomIn(restaurantPane8).setDelay(Duration.seconds(0.5)).play();
        restaurantName8.setText(Restaurant.restaurantName[7]);
        restaurantType8.setText(Restaurant.restaurantType[7]);
        restaurantRate8.setText(String.valueOf(Restaurant.restaurantRate[7]));
        if(String.valueOf(Restaurant.restaurantStatus[7]).equals("true"))
        {
            restaurantOpenStatus8.setVisible(true);
        }
        else
        {
            restaurantCloseStatus8.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Restaurant 9">
        restaurantPane9.setOpacity(0.0);
        new ZoomIn(restaurantPane9).setDelay(Duration.seconds(0.5)).play();
        restaurantName9.setText(Restaurant.restaurantName[8]);
        restaurantType9.setText(Restaurant.restaurantType[8]);
        restaurantRate9.setText(String.valueOf(Restaurant.restaurantRate[8]));
        if(String.valueOf(Restaurant.restaurantStatus[8]).equals("true"))
        {
            restaurantOpenStatus9.setVisible(true);
        }
        else
        {
            restaurantCloseStatus9.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Restaurant 10">
        restaurantPane10.setOpacity(0.0);
        new ZoomIn(restaurantPane10).setDelay(Duration.seconds(0.5)).play();
        restaurantName10.setText(Restaurant.restaurantName[9]);
        restaurantType10.setText(Restaurant.restaurantType[9]);
        restaurantRate10.setText(String.valueOf(Restaurant.restaurantRate[9]));
        if(String.valueOf(Restaurant.restaurantStatus[9]).equals("true"))
        {
            restaurantOpenStatus10.setVisible(true);
        }
        else
        {
            restaurantCloseStatus10.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Restaurant 11">
        restaurantPane11.setOpacity(0.0);
        new ZoomIn(restaurantPane11).setDelay(Duration.seconds(0.5)).play();
        restaurantName11.setText(Restaurant.restaurantName[10]);
        restaurantType11.setText(Restaurant.restaurantType[10]);
        restaurantRate11.setText(String.valueOf(Restaurant.restaurantRate[10]));
        if(String.valueOf(Restaurant.restaurantStatus[10]).equals("true"))
        {
            restaurantOpenStatus11.setVisible(true);
        }
        else
        {
            restaurantCloseStatus11.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Restaurant 12">
        restaurantPane12.setOpacity(0.0);
        new ZoomIn(restaurantPane12).setDelay(Duration.seconds(0.5)).play();
        restaurantName12.setText(Restaurant.restaurantName[11]);
        restaurantType12.setText(Restaurant.restaurantType[11]);
        restaurantRate12.setText(String.valueOf(Restaurant.restaurantRate[11]));
        if(String.valueOf(Restaurant.restaurantStatus[11]).equals("true"))
        {
            restaurantOpenStatus12.setVisible(true);
        }
        else
        {
            restaurantCloseStatus12.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Restaurant 13">
        restaurantPane13.setOpacity(0.0);
        new ZoomIn(restaurantPane13).setDelay(Duration.seconds(0.5)).play();
        restaurantName13.setText(Restaurant.restaurantName[12]);
        restaurantType13.setText(Restaurant.restaurantType[12]);
        restaurantRate13.setText(String.valueOf(Restaurant.restaurantRate[12]));
        if(String.valueOf(Restaurant.restaurantStatus[12]).equals("true"))
        {
            restaurantOpenStatus13.setVisible(true);
        }
        else
        {
            restaurantCloseStatus13.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Restaurant 14">
        restaurantPane14.setOpacity(0.0);
        new ZoomIn(restaurantPane14).setDelay(Duration.seconds(0.5)).play();
        restaurantName14.setText(Restaurant.restaurantName[13]);
        restaurantType14.setText(Restaurant.restaurantType[13]);
        restaurantRate14.setText(String.valueOf(Restaurant.restaurantRate[13]));
        if(String.valueOf(Restaurant.restaurantStatus[13]).equals("true"))
        {
            restaurantOpenStatus14.setVisible(true);
        }
        else
        {
            restaurantCloseStatus14.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Restaurant 15">
        restaurantPane15.setOpacity(0.0);
        new ZoomIn(restaurantPane15).setDelay(Duration.seconds(0.5)).play();
        restaurantName15.setText(Restaurant.restaurantName[14]);
        restaurantType15.setText(Restaurant.restaurantType[14]);
        restaurantRate15.setText(String.valueOf(Restaurant.restaurantRate[14]));
        if(String.valueOf(Restaurant.restaurantStatus[14]).equals("true"))
        {
            restaurantOpenStatus15.setVisible(true);
        }
        else
        {
            restaurantCloseStatus15.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Restaurant 16">
        restaurantPane16.setOpacity(0.0);
        new ZoomIn(restaurantPane16).setDelay(Duration.seconds(0.5)).play();
        restaurantName16.setText(Restaurant.restaurantName[15]);
        restaurantType16.setText(Restaurant.restaurantType[15]);
        restaurantRate16.setText(String.valueOf(Restaurant.restaurantRate[15]));
        if(String.valueOf(Restaurant.restaurantStatus[15]).equals("true"))
        {
            restaurantOpenStatus16.setVisible(true);
        }
        else
        {
            restaurantCloseStatus16.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Restaurant 17">
        restaurantPane17.setOpacity(0.0);
        new ZoomIn(restaurantPane17).setDelay(Duration.seconds(0.5)).play();
        restaurantName17.setText(Restaurant.restaurantName[16]);
        restaurantType17.setText(Restaurant.restaurantType[16]);
        restaurantRate17.setText(String.valueOf(Restaurant.restaurantRate[16]));
        if(String.valueOf(Restaurant.restaurantStatus[16]).equals("true"))
        {
            restaurantOpenStatus17.setVisible(true);
        }
        else
        {
            restaurantCloseStatus17.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Restaurant 18">
        restaurantPane18.setOpacity(0.0);
        new ZoomIn(restaurantPane18).setDelay(Duration.seconds(0.5)).play();
        restaurantName18.setText(Restaurant.restaurantName[17]);
        restaurantType18.setText(Restaurant.restaurantType[17]);
        restaurantRate18.setText(String.valueOf(Restaurant.restaurantRate[17]));
        if(String.valueOf(Restaurant.restaurantStatus[17]).equals("true"))
        {
            restaurantOpenStatus18.setVisible(true);
        }
        else
        {
            restaurantCloseStatus18.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Restaurant 19">
        restaurantPane19.setOpacity(0.0);
        new ZoomIn(restaurantPane19).setDelay(Duration.seconds(0.5)).play();
        restaurantName19.setText(Restaurant.restaurantName[18]);
        restaurantType19.setText(Restaurant.restaurantType[18]);
        restaurantRate19.setText(String.valueOf(Restaurant.restaurantRate[18]));
        if(String.valueOf(Restaurant.restaurantStatus[18]).equals("true"))
        {
            restaurantOpenStatus19.setVisible(true);
        }
        else
        {
            restaurantCloseStatus19.setVisible(true);
        }
        //</editor-fold>

    }
    public void GeneratePark()
    {
        //<editor-fold default-state="collapsed" desc="Park 1">
        parkPane1.setOpacity(0.0);
        new ZoomIn(parkPane1).setDelay(Duration.seconds(0.5)).play();
        parkName1.setText(Park.parkName[0]);
        parkType1.setText(Park.parkType[0]);
        parkRate1.setText(String.valueOf(Park.parkRate[0]));
        if(String.valueOf(Park.parkStatus[0]).equals("true"))
        {
            parkOpenStatus1.setVisible(true);
        }
        else
        {
            parkCloseStatus1.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Park 2">
        parkPane2.setOpacity(0.0);
        new ZoomIn(parkPane2).setDelay(Duration.seconds(0.5)).play();
        parkName2.setText(Park.parkName[1]);
        parkType2.setText(Park.parkType[1]);
        parkRate2.setText(String.valueOf(Park.parkRate[1]));
        if(String.valueOf(Park.parkStatus[1]).equals("true"))
        {
            parkOpenStatus2.setVisible(true);
        }
        else
        {
            parkCloseStatus2.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Park 3">
        parkPane3.setOpacity(0.0);
        new ZoomIn(parkPane3).setDelay(Duration.seconds(0.5)).play();
        parkName3.setText(Park.parkName[2]);
        parkType3.setText(Park.parkType[2]);
        parkRate3.setText(String.valueOf(Park.parkRate[2]));
        if(String.valueOf(Park.parkStatus[2]).equals("true"))
        {
            parkOpenStatus3.setVisible(true);
        }
        else
        {
            parkCloseStatus3.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Park 4">
        parkPane4.setOpacity(0.0);
        new ZoomIn(parkPane4).setDelay(Duration.seconds(0.5)).play();
        parkName4.setText(Park.parkName[3]);
        parkType4.setText(Park.parkType[3]);
        parkRate4.setText(String.valueOf(Park.parkRate[3]));
        if(String.valueOf(Park.parkStatus[3]).equals("true"))
        {
            parkOpenStatus4.setVisible(true);
        }
        else
        {
            parkCloseStatus4.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Park 5">
        parkPane5.setOpacity(0.0);
        new ZoomIn(parkPane5).setDelay(Duration.seconds(0.5)).play();
        parkName5.setText(Park.parkName[4]);
        parkType5.setText(Park.parkType[4]);
        parkRate5.setText(String.valueOf(Park.parkRate[4]));
        if(String.valueOf(Park.parkStatus[4]).equals("true"))
        {
            parkOpenStatus5.setVisible(true);
        }
        else
        {
            parkCloseStatus5.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Park 6">
        parkPane6.setOpacity(0.0);
        new ZoomIn(parkPane6).setDelay(Duration.seconds(0.5)).play();
        parkName6.setText(Park.parkName[5]);
        parkType6.setText(Park.parkType[5]);
        parkRate6.setText(String.valueOf(Park.parkRate[5]));
        if(String.valueOf(Park.parkStatus[5]).equals("true"))
        {
            parkOpenStatus6.setVisible(true);
        }
        else
        {
            parkCloseStatus6.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Park 7">
        parkPane7.setOpacity(0.0);
        new ZoomIn(parkPane7).setDelay(Duration.seconds(0.5)).play();
        parkName7.setText(Park.parkName[6]);
        parkType7.setText(Park.parkType[6]);
        parkRate7.setText(String.valueOf(Park.parkRate[6]));
        if(String.valueOf(Park.parkStatus[6]).equals("true"))
        {
            parkOpenStatus7.setVisible(true);
        }
        else
        {
            parkCloseStatus7.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Park 8">
        parkPane8.setOpacity(0.0);
        new ZoomIn(parkPane8).setDelay(Duration.seconds(0.5)).play();
        parkName8.setText(Park.parkName[7]);
        parkType8.setText(Park.parkType[7]);
        parkRate8.setText(String.valueOf(Park.parkRate[7]));
        if(String.valueOf(Park.parkStatus[7]).equals("true"))
        {
            parkOpenStatus8.setVisible(true);
        }
        else
        {
            parkCloseStatus8.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Park 9">
        parkPane9.setOpacity(0.0);
        new ZoomIn(parkPane9).setDelay(Duration.seconds(0.5)).play();
        parkName9.setText(Park.parkName[8]);
        parkType9.setText(Park.parkType[8]);
        parkRate9.setText(String.valueOf(Park.parkRate[8]));
        if(String.valueOf(Park.parkStatus[8]).equals("true"))
        {
            parkOpenStatus9.setVisible(true);
        }
        else
        {
            parkCloseStatus9.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Park 10">
        parkPane10.setOpacity(0.0);
        new ZoomIn(parkPane10).setDelay(Duration.seconds(0.5)).play();
        parkName10.setText(Park.parkName[9]);
        parkType10.setText(Park.parkType[9]);
        parkRate10.setText(String.valueOf(Park.parkRate[9]));
        if(String.valueOf(Park.parkStatus[9]).equals("true"))
        {
            parkOpenStatus10.setVisible(true);
        }
        else
        {
            parkCloseStatus10.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Park 11">
        parkPane11.setOpacity(0.0);
        new ZoomIn(parkPane11).setDelay(Duration.seconds(0.5)).play();
        parkName11.setText(Park.parkName[10]);
        parkType11.setText(Park.parkType[10]);
        parkRate11.setText(String.valueOf(Park.parkRate[10]));
        if(String.valueOf(Park.parkStatus[10]).equals("true"))
        {
            parkOpenStatus11.setVisible(true);
        }
        else
        {
            parkCloseStatus11.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Park 12">
        parkPane12.setOpacity(0.0);
        new ZoomIn(parkPane12).setDelay(Duration.seconds(0.5)).play();
        parkName12.setText(Park.parkName[11]);
        parkType12.setText(Park.parkType[11]);
        parkRate12.setText(String.valueOf(Park.parkRate[11]));
        if(String.valueOf(Park.parkStatus[11]).equals("true"))
        {
            parkOpenStatus12.setVisible(true);
        }
        else
        {
            parkCloseStatus12.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Park 13">
        parkPane13.setOpacity(0.0);
        new ZoomIn(parkPane13).setDelay(Duration.seconds(0.5)).play();
        parkName13.setText(Park.parkName[12]);
        parkType13.setText(Park.parkType[12]);
        parkRate13.setText(String.valueOf(Park.parkRate[12]));
        if(String.valueOf(Park.parkStatus[12]).equals("true"))
        {
            parkOpenStatus13.setVisible(true);
        }
        else
        {
            parkCloseStatus13.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Park 14">
        parkPane14.setOpacity(0.0);
        new ZoomIn(parkPane14).setDelay(Duration.seconds(0.5)).play();
        parkName14.setText(Park.parkName[13]);
        parkType14.setText(Park.parkType[13]);
        parkRate14.setText(String.valueOf(Park.parkRate[13]));
        if(String.valueOf(Park.parkStatus[13]).equals("true"))
        {
            parkOpenStatus14.setVisible(true);
        }
        else
        {
            parkCloseStatus14.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Park 15">
        parkPane15.setOpacity(0.0);
        new ZoomIn(parkPane15).setDelay(Duration.seconds(0.5)).play();
        parkName15.setText(Park.parkName[14]);
        parkType15.setText(Park.parkType[14]);
        parkRate15.setText(String.valueOf(Park.parkRate[14]));
        if(String.valueOf(Park.parkStatus[14]).equals("true"))
        {
            parkOpenStatus15.setVisible(true);
        }
        else
        {
            parkCloseStatus15.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Park 16">
        parkPane16.setOpacity(0.0);
        new ZoomIn(parkPane16).setDelay(Duration.seconds(0.5)).play();
        parkName16.setText(Park.parkName[15]);
        parkType16.setText(Park.parkType[15]);
        parkRate16.setText(String.valueOf(Park.parkRate[15]));
        if(String.valueOf(Park.parkStatus[15]).equals("true"))
        {
            parkOpenStatus16.setVisible(true);
        }
        else
        {
            parkCloseStatus16.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Park 17">
        parkPane17.setOpacity(0.0);
        new ZoomIn(parkPane17).setDelay(Duration.seconds(0.5)).play();
        parkName17.setText(Park.parkName[16]);
        parkType17.setText(Park.parkType[16]);
        parkRate17.setText(String.valueOf(Park.parkRate[16]));
        if(String.valueOf(Park.parkStatus[16]).equals("true"))
        {
            parkOpenStatus17.setVisible(true);
        }
        else
        {
            parkCloseStatus17.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Park 18">
        parkPane18.setOpacity(0.0);
        new ZoomIn(parkPane18).setDelay(Duration.seconds(0.5)).play();
        parkName18.setText(Park.parkName[17]);
        parkType18.setText(Park.parkType[17]);
        parkRate18.setText(String.valueOf(Park.parkRate[17]));
        if(String.valueOf(Park.parkStatus[17]).equals("true"))
        {
            parkOpenStatus18.setVisible(true);
        }
        else
        {
            parkCloseStatus18.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Park 19">
        parkPane19.setOpacity(0.0);
        new ZoomIn(parkPane19).setDelay(Duration.seconds(0.5)).play();
        parkName19.setText(Park.parkName[18]);
        parkType19.setText(Park.parkType[18]);
        parkRate19.setText(String.valueOf(Park.parkRate[18]));
        if(String.valueOf(Park.parkStatus[18]).equals("true"))
        {
            parkOpenStatus19.setVisible(true);
        }
        else
        {
            parkCloseStatus19.setVisible(true);
        }
        //</editor-fold>
        //<editor-fold default-state="collapsed" desc="Park 20">
        parkPane20.setOpacity(0.0);
        new ZoomIn(parkPane20).setDelay(Duration.seconds(0.5)).play();
        parkName20.setText(Park.parkName[19]);
        parkType20.setText(Park.parkType[19]);
        parkRate20.setText(String.valueOf(Park.parkRate[19]));
        if(String.valueOf(Park.parkStatus[19]).equals("true"))
        {
            parkOpenStatus20.setVisible(true);
        }
        else
        {
            parkCloseStatus20.setVisible(true);
        }
        //</editor-fold>

    }

    public void GenerateRecommended()
    {
        //<editor-fold default-state="collapsed" desc="Recommended Shop 1">
        recName1.setText(Church.churchName[2]);
        recType1.setText(Church.churchType[2]);
        recRate1.setText(String.valueOf(Church.churchRate[2]));
        recImage1.setImage(new Image(getClass().getResourceAsStream("gui/churchCategory.png")));
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
        recImage2.setImage(new Image(getClass().getResourceAsStream("gui/barImageCategory.png")));
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
        recImage3.setImage(new Image(getClass().getResourceAsStream("gui/musuemCategory.png")));
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
        recImage4.setImage(new Image(getClass().getResourceAsStream("gui/restaurantCategory.png")));
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
        recImage5.setImage(new Image(getClass().getResourceAsStream("gui/parkCategory.png")));
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
        searchResultsPanel.setVisible(true);
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
    protected Favourite setFavouriteFill()
    {
        new BounceIn(favouriteCafe1).play();
        favouriteCafe1.setImage(new Image(getClass().getResourceAsStream("gui/favourite.png")));

        final String DB_URL = "jdbc:mysql://localhost/testing?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";
        String name = Cafe.cafeName[0];
        Favourite favourite = null;

        try {
            Connection conn2 = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt2 = conn2.createStatement();
            String sql2 = "DELETE FROM favourite WHERE name='"+name+"';";
            stmt2.execute(sql2);
            System.out.println("favourite Database Deleted");
            stmt2.close();
            conn2.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return favourite;
    }

}