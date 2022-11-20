module com.example.tourist_application {
    requires javafx.controls;
    requires javafx.fxml;
    requires AnimateFX;
    requires org.json;
    requires java.net.http;
    requires java.sql;


    opens com.example.tourist_application to javafx.fxml;
    exports com.example.tourist_application;
}